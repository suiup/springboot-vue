<template>
    <div>
        <h1>Register for myHarvest</h1>
        <form>
            <table class="registerTable">
                <tr>
                    <td>
                        <label htmlFor="username">Username:</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="username" id="username" v-model="username" class="form">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label htmlFor="email">Email:</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="email" name="email" id="email" v-model="email" class="form">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label htmlFor="password">Password:</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="password" name="password" id="password" v-model="password" class="form">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label htmlFor="check_password">Password (confirm):</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="password" name="check_password" id="check_password" v-model="check_password" class="form">
                    </td>
                </tr>
            </table>
            <input type="button" value="create" v-on:click="submit" style="width: auto">
        </form>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "Register.vue",
        props: {
            msg: String
        },
        data() {
            return {
                username: "",
                email: "",
                password: "",
                check_password: ""
            }
        },
        methods: {
            submit() {
                let reg = new RegExp("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$")
                if (!reg.test(this.email)) {
                    alert("The email format submitted is incorrect, please check it again!");
                    return null;
                }
                const _this = this;
                if (this.password === this.check_password) {
                    axios.post("/User/add", {
                        username: this.username,
                        email: this.email,
                        password: this.password
                    }).then(function (data) {
                        console.log(data);
                        if (data.data.success) {
                            _this.$router.push('/login');
                        } else {
                            alert(data.data.msg);
                        }
                    }).catch(error => console.log(error))
                } else {
                    alert("password is not the same, please input again")
                }
            }
        }
    }
</script>

<style scoped>

    .registerTable {
        width: 100%;
        padding-left: 41%;
        text-align: left;
    }

    .form {
        width: 30%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=button] {
        width: 20%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=button]:hover {
        background-color: #45a049;
    }

    @media screen and (max-width: 800px) {
        .registerTable {
            width: 100%;
        }
    }


</style>