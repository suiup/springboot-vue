<template>
    <div id="top">
        <h1>Login to myharvest</h1>
        <form>
            <table class="loginTable">
                <label for="username">Username:</label><br>
                <input type="text" v-model="username" id="username" class="form"><br>
                <label for="password">Password:</label><br>
                <input type="password" v-model="password" id="password" class="form"><br>
            </table>
            <input type="button" v-on:click="login" value="Login" style="width: auto">
        </form>
        <br>
        <router-link :to="{name: 'register'}" id="link">Register as new User</router-link>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "login.vue",
        data() {
            return {
                username: "",
                password: ""
            }
        },
        methods: {
            login() {
                const _this = this;
                axios.get("/User/login?username=" + this.username + "&password=" + this.password).then(function (res) {
                    console.log(res)
                    if (res.data.code == 200) {
                        localStorage.setItem('token', res.data.data.authorization);
                        localStorage.setItem('userId', res.data.data.id);
                        localStorage.setItem('username', res.data.data.username);
                        _this.$router.push('/');
                        location.reload();
                    } else {
                        alert(res.data.msg);
                    }

                }).catch(error => console.log(error))
            }
        }
    }
</script>

<style scoped>
    .loginTable {
        padding-left: 42%;
        text-align: left;
        width: 75%;
    }

    .form {
       /* width: 50%; */
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    #link:link {
        text-decoration: none;
        color: #84cf6a;
    }

    #link:visited {
        text-decoration: none;
    }

    #link:hover {
        text-decoration: underline;
        color: red;
    }

    #link:active {
        text-decoration: underline;
    }

    #top {
        padding-top: 5%;
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
</style>