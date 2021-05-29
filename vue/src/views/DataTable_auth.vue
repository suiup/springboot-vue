<template>
    <div>
        <!-- <h1>DataTable Management</h1> -->
        <p style="text-align:center;font-size:40px">DataTable Management</p>
        <form>
            <table class="dataTable" style="width:70%" align="center" border="1" cellpadding="10" cellspacing="2" bgcolor="#f5f5f5">
                <thead>
                <tr style="font-weight: bold">
                    <td>ID</td>
                    <td>Auth</td>
                    <td>Operation</td>
                </tr>
                </thead>

                <tbody>
                <tr v-for="item in authData" :key="item.authId">
                    <td>{{ item.authId}}</td>
                    <td>{{ item.authName }}</td>
                    <td>
                        <input type="button" value="Delete" v-on:click="deleteMethod(item.authId)"/> &nbsp;
                        <input type="button" value="Edit" v-on:click="show(item)"/>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
        <br>
        <modal name="my-auth-modal"
               classes="demo-modal-class"
               :min-width="200"
               :min-height="200"
               :scrollable="true"
               :resizable="true"
               :reset="true"
               width="60%"
               height="auto">
            <form style="border-radius: 5px; background-color: #f2f2f2; padding: 20px;">
                <label for="authId">ID (no modification allowed):</label>
                <input type="text" id="authId" v-model="authId" disabled>

                <label for="authName">authName: </label>
                <input type="text" id="authName" v-model="authName" >

                <input type="button" value="Submit" v-on:click="updateMethod">
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
        name: "datatable_auth.vue",
        data() {
            return {
                authId:"",
                authName:"",
               // isDel: 0,
                authData:[]
            }
        },
        created(){
            this.getAuthData()
        },
        methods: {
            show(item){
                this.authId = item.authId;
                this.authName = item.authName;
                this.$modal.show('my-auth-modal');
            },
            hide(){
                this.$modal.hide('my-auth-modal');
            },
            updateMethod(){
                if (confirm("Do you want to submit your changes?")) {
                    axios.post("/Auth/add",{
                        authId: this.authId,
                        authName: this.authName,
                    }).then(function (data) {
                        console.log(data);
                        alert("Edit successfully!")
                        location.reload();
                    }).catch(error => console.log(error))
                }
            },
            getAuthData() {
                axios.get("/Auth/findAll").then(response => (this.authData = response.data.data));
            },
            deleteMethod(index) {
                if (confirm("Do you want to delete the selected data?")) {
                    axios.get("/Auth/delete/" + index).then(response => (this.authData = response.data.data));
                    alert("Delete successfully!");
                    location.reload();
                    /*
                    axios.get("/Auth/delete/" + index)
                        .then(function (response) {
                            console.log("authData: " + response.data.data);
                            console.log("authData.data: " + response.data);

                            if(this.authData.isDel==1){
                                console.log("isDel: " + this.authData.isDel);
                                alert("Delete successfully!")
                            } else alert("Fail to delete, because the data cannot be modified.")
                        }); */
                }
            }
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
