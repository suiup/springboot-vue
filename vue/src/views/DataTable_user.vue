<template>
    <div>
        <!-- <h1>DataTable Management</h1> -->
        <p style="text-align:center;font-size:40px">DataTable Management</p>
        <form>
            <table align="center" style="width: 70%" border="1" cellpadding="10" cellspacing="2" bgcolor="#f5f5f5">
                <thead>
                <tr style="font-weight: bold">
                    <td>ID</td>
                    <td>UserName</td>
                    <td>Password</td>
                    <td>Email</td>
                    <td>Operation</td>
                </tr>
                </thead>

                <tbody>
                <tr v-for="item in userData" :key="item.id">
                    <td>{{ item.id}}</td>
                    <td>{{ item.username }}</td>
                    <td>{{ item.password }}</td>
                    <td>{{ item.email }}</td>
                    <td>
                        <input type="button" value="Delete" v-on:click="deleteMethod(item.id)"/> &nbsp;
                        <input type="button" value="Edit" v-on:click="show(item)"/>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
        <br>
        <modal name="my-user-modal"
               classes="demo-modal-class"
               :min-width="200"
               :min-height="200"
               :scrollable="true"
               :resizable="true"
               :reset="true"
               width="60%"
               height="auto">
            <form style="border-radius: 5px; background-color: #f2f2f2; padding: 20px;">
                <label for="editID">ID (no modification allowed):</label>
                <input type="text" id="editID" v-model="editID" disabled>

                <label for="username">Username: </label>
                <input type="text" id="username" v-model="username" >

                <label for="email">Email: </label>
                <input type="text" id="email" v-model="email" >

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
        name: "datatable_user.vue",
        data() {
            return {
                editID:"",
                username: "",
                password: "",
                email:"",
                userData:[]
            }
        },
        created(){
            this.getUserData()
        },
        methods: {
            show(item){
                this.editID = item.id;
                this.username = item.username;
                this.password = item.password;
                this.email = item.email;
                this.$modal.show('my-user-modal');
            },
            hide(){
                this.$modal.hide('my-user-modal');
            },
            updateMethod(){
                let reg = new RegExp("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$")
                if(!reg.test(this.email)){
                    alert("The email format submitted is incorrect, please check it again!")
                    return null;
                }
                axios.post("/User/add",{
                    id: this.editID,
                    username: this.username,
                    password: this.password,
                    email: this.email
                }).then(function (data) {
                    console.log(data);
                    alert("Edit successfully!");
                    location.reload();
                }).catch(error => console.log(error))
            },
            getUserData() {
                axios.get("/User/findAll").then(response => (this.userData = response.data.data)).catch(error => console.log(error));
            },
            deleteMethod(index) {
                if (confirm("Do you want to delete the selected data?")) {
                    axios.get("/User/delete/" + index).then(function (res) {
                       console.log(res);
                       if(res.data.success){
                           alert("Delete successfully!")
                           location.reload();
                           this.userData = res.data.data;
                       }else{
                            alert("server error");
                       }
                    });
                    axios.get("/User/delete/" + index).then(response => (this.userData = response.data.data));

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
