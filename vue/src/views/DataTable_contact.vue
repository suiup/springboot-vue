<template>
    <div class="mediaTable">
        <!-- <h1>DataTable Management</h1> -->
        <p style="text-align:center;font-size:40px">DataTable Management</p>
        <form>
            <table class="dataTable" style="width:70%" align="center" border="1" cellpadding="10" cellspacing="2" bgcolor="#f5f5f5">
                <thead>
                <tr style="font-weight: bold">
                    <td>ID</td>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Message</td>
                    <td>Time</td>
                    <td>Operation</td>
                </tr>
                </thead>

                <tbody>
                <tr v-for="item in contactData" :key="item.contactId">
                    <td >{{ item.contactId}}</td>
                    <td>{{ item.contactName }}</td>
                    <td>{{ item.contactEmail }}</td>
                    <td v-text="item.contactMessage" style="word-break:break-all"></td>
                    <td>{{ item.contactTime }}</td>
                    <td>
                        <input type="button" value="Delete" v-on:click="deleteMethod(item.contactId)"/> &nbsp;
                        <input type="button" value="Edit" v-on:click="show(item)"/>
                        <!-- <button class="submitButton" v-on:click="submitMethod">SUBMIT</button> -->
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
        <br>

        <modal name="my-contact-modal"
               classes="demo-modal-class"
               :min-width="200"
               :min-height="200"
               :scrollable="true"
               :resizable="true"
               :reset="true"
               width="60%"
               height="auto">
            <form style="border-radius: 5px; background-color: #f2f2f2; padding: 20px;">
                <label for="contactId">ID (no modification allowed):</label>
                <input type="text" id="contactId" v-model="contactId" disabled>

                <label for="contactName">Name: </label>
                <input type="text" id="contactName" v-model="contactName" >

                <label for="contactEmail">Email: </label>
                <input type="text" id="contactEmail" v-model="contactEmail" >

                <label for="contactMessage">Message: </label>
                <input type="text" id="contactMessage" v-model="contactMessage" >

                <label for="contactTime">Time: </label>
                <input type="text" id="contactTime" v-model="contactTime" disabled>

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
        name: "datatable_contact.vue",
        data() {
            return {
                contactId: "",
                contactName:"",
                contactEmail:"",
                contactMessage:"",
                contactTime:"",
                contactData:[]
            }
        },
        created(){
            this.getContactData()
        },
        methods: {
            show(item){
                this.contactId = item.contactId;
                this.contactName = item.contactName;
                this.contactEmail = item.contactEmail;
                this.contactMessage = item.contactMessage;
                this.contactTime = item.contactTime;
                this.$modal.show('my-contact-modal');
            },
            hide(){
                this.$modal.hide('my-contact-modal');
            },
            updateMethod(){
                let reg = new RegExp("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");
                if(!reg.test(this.contactEmail)){
                    alert("The email format submitted is incorrect, please check it again!");
                    return null;
                }
                axios.post("/contact/add",{
                    contactId: this.contactId,
                    contactName: this.contactName,
                    contactEmail: this.contactEmail,
                    contactMessage: this.contactMessage,
                    contactTime: this.contactTime,
                }).then(function (data) {
                    console.log(data);
                    alert('Edit successfully!')
                    location.reload();
                }).catch(error => console.log(error))
            },
            getContactData() {
                axios.get("/contact/findAll").then(response => (this.contactData = response.data.data));
            },
            deleteMethod(index) {
                if (confirm("Do you want to delete the selected data?")) {
                    axios.get("/contact/deleteContactById/" + index).then(response => (this.contactData = response.data.data));
                    alert("Delete successfully!")
                    setTimeout(()=>{
                        location.reload();
                    },1000);
                }
            }
        }
    }
</script>

<style>
    label{
        float: left;
    }

    textarea, input[type=text], select {
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

    @media screen and (max-width: 800px) {
        .mediaTable {
            width: 70%;
            padding: 10px;
        }
    }

    @media screen and (max-width: 800px) {
        .tableBody {
            width: 70%;
            padding: 10px;
        }
    }

</style>
