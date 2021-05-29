<template>
    <div>
        <p style="text-align:center;font-size:40px">DataTable Management</p >
        <form>
            <table align="center" border="1" cellpadding="10" cellspacing="2" bgcolor="#f5f5f5">
                <thead>
                    <tr style="font-weight: bold">
                        <td>ID</td>
                        <td>Who</td>
                        <td>What Time</td>
                        <td>What Table</td>
                        <td>What Operation</td>
                        <td>What Tuple</td>
                        <td>Operation</td>
                    </tr>
                </thead>

                <tbody>
                    <tr v-for="item in logData" :key="item.logId">
                        <td>{{ item.logId}}</td>
                        <td>{{ item.who }}</td>
                        <td v-text="item.whatTime"></td>
                      <!--  <td>{{ item.whatTime }}</td> -->
                        <td>{{ item.whatTable }}</td>
                        <td>{{ item.whatOperation }}</td>
                        <td>{{ item.whatTuple }}</td>
                        <td>
                            <input type="button" value="Delete" v-on:click="deleteMethod(item.logId)"/> &nbsp;
                            <input type="button" value="Edit" v-on:click="show(item)"/>
                            <!-- <button class="submitButton" v-on:click="submitMethod">SUBMIT</button> -->
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <modal name="my-first-modal"
               classes="demo-modal-class"
               :min-width="200"
               :min-height="200"
               :scrollable="true"
               :resizable="true"
               :reset="true"
               width="60%"
               height="auto">
            <form style="border-radius: 5px; background-color: #f2f2f2; padding: 20px;">
                <label for="editID">ID: {{ singleLogData.logId }}</label>
                <input type="text" id="editID" v-model="newID" value="Please enter new 'ID'." disabled>

                <label for="editWho">Who: {{ singleLogData.who }}</label>
                <input type="text" id="editWho" v-model="newWho" placeholder="Please enter new 'Who'.">

                <label for="editTime">Time: {{ singleLogData.whatTime }}</label>
                <input type="text" id="editTime" v-model="newTime" disabled placeholder="Please enter new 'Time'.">

                <label for="editTable">Table: {{ singleLogData.whatTable }}</label>
                <input type="text" id="editTable" v-model="newTable" placeholder="Please enter new 'Table'.">

                <label for="editOperation">Operation: {{ singleLogData.whatOperation }}</label>
                <input type="text" id="editOperation" v-model="newOperation" placeholder="Please enter new 'Operation'.">

                <label for="editTuple">Tuple: {{ singleLogData.whatTuple }}</label>
                <input type="text" id="editTuple" v-model="newTuple" placeholder="Please enter new 'Tuple'.">

                <input type="button"  value="Submit" v-on:click="updateMethod">
            </form>
        </modal>
        <p>
            Note that the database sever is updating slowly, <br>
            please wait for a while and the data will be displayed soon.
        </p>
        <router-link :to="{name: 'home'}"> <input type="button" value="Home"> </router-link> &nbsp;
        <input type="button" value="Return" onclick="javascript:history.back(-1);"/>
    </div>
</template>

<script>
    import axios from "axios";


    export default {
        name: "datatable_log.vue",
        data() {
            return {
                newID:"",
                newWho:"",
                newTime:"",
                newTable:"",
                newOperation:"",
                newTuple:"",
                singleLogData:[],

                log_id:"",
               // log_id:"", //test: test_logId()
                logData:[] //test: getLogData2()
                /*
                logData:{ //test: getLogData1()
                    logId: "",
                    who: "",
                    whatTime: "",
                    whatTable: "",
                    whatOperation: "",
                    whatTuple: ""
                }
                */
            }
        },
        created(){
            this.getAllLogData()
        },
        methods: {
            show(item){
                this.newID = item.logId;
                this.newWho = item.who;
                this.newTime = item.whatTime;
                this.newTable = item.whatTable;
                this.newOperation = item.whatOperation;
                this.newTuple = item.whatTuple;
                this.$modal.show('my-first-modal');
            },
            hide(){
                this.$modal.hide('my-first-modal');
            },
            updateMethod(){
                axios.post("/log/add",{
                    logId: this.newId,
                    who: this.newWho,
                    whatTime: this.newTime,
                    whatTable: this.newTable,
                    whatOperation: this.newOperation,
                    whatTuple: this.newTuple
                }).then(function (data) {
                    console.log(data);
                    alert('edit successful...')
                    location.reload();
                }).catch(error => console.log(error))
            },
            test_logId() {
                const _this = this
                console.log("[test] test()")
                axios.get("/log/findLogById/" + this.log_id ).then(function (resp) {
                    console.log("[Test data] " + resp)
                    if(resp.data.code == 200){
                        _this.logData = resp.data.data
                        console.log("[Test code] " + resp.data.code)
                        console.log("[Test data] " + resp.data.data.who)
                    }else{
                        console.log("Log is wrong")
                    }
                }).catch(error => console.log(error))
            },
            getLogData1() {
                const _this = this
                console.log("[test] getLogData")
                axios.get("/log/findAll").then(function (resp) {
                    console.log("[Test data] " + resp.data.data)
                    _this.logData = resp.data.data
                    _this.logData.logId = resp.data.data.logId
                    _this.logData.who = resp.data.data.who
                    _this.logData.whatTime = resp.data.data.whatTime
                    _this.logData.whatTable = resp.data.data.whatTable
                    _this.logData.whatOperation = resp.data.data.whatOperation
                    _this.logData.whatTuple = resp.data.data.whatTuple
                    console.log("[Test data] " + _this.logData)
                    console.log("[Test code] " + resp.data.code)
                }).catch(error => console.log(error))
            },
            getAllLogData() {
               // console.log("[test] getLogData2")
                axios.get("/log/findAll").then(response => (this.logData = response.data.data));
            },
            deleteMethod(index) {
              //  let selectedItem = index
                if (confirm("Do you want to delete the selected data?")) {
                    console.log("[test] deleteMethod" )
                    axios.get("/log/deleteLogById/" + index).then(response => (this.logData = response.data.data));
                    alert("Successfully submitted!")
                }
                location.reload();
            }//deleteMethod()

        }
    }
</script>

<style>
    label{
        float: left;
    }

    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]:hover {
        background-color: #45a049;
    }


    input[type=button] {
        background-color: #7db4af;
        color: #f2f2f2;
        border: none;
        border-radius: 4px;
        font-size: 15px;
        text-align: center;
        cursor: pointer;
        padding: 10px 15px;
        margin: 8px 0;
    }

    input[type=button]:hover {
        background-color: #45a049;
    }
</style>
