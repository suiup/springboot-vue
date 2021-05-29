<head>
    <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
</head>

<template>
    <div>
        <!-- Layout: three column -->
        <div class="row">
            <!-- Layout: column 1 -->
            <div class="column" id="app">
                <h3>CONTACT</h3>
                <p>
                    Would you like to find out more about MYHarvest?
                    Or want some help with measuring you produce or submitting your data?
                    We’d love to hear from you, so please get in touch through the form.
                </p>
                <p> Note that fields marked with an <strong style="color:#e37d96;">*</strong> are required </p>
                <br><br><br>

                <p>
                    Dept. Animal & Plant Sciences <br>
                    Alfred Denny Building <br>
                    The University of Sheffield <br>
                    Western Bank <br>
                    Sheffield <br>
                    S10 2TN <br>
                    UK <br>
                    <br>
                    myharvest@sheffield.ac.uk <br>
                    <br>
                    0114 222 0062 <br>
                    <br>
                    <img :src="twitterlogo" width="21" height="21" alt="" />
                    Facebook: <a href="https://twitter.com/myharvestuk/" style="color:#4e4a4a;">/MYHarvestUK</a> <br>
                    <img :src="Instagramlogo" width="21" height="21" alt=""/>
                    Twitter: <a href="https://www.facebook.com/MYHarvestUK/" style="color:#4e4a4a;">@MYHarvestUK</a> <br>
                    <img :src="facebooklogo" width="21" height="21" alt=""/>
                    Instagram: <a href="https://www.instagram.com/myharvestuk/" style="color:#4e4a4a;">@MYHarvestUK</a> <br>
                </p>
            </div>

            <!-- Layout: column 2 -->
            <div class="column">
                <p>
                    <strong> Name </strong>
                    <strong style="color:#e37d96;"> * </strong>
                </p>
                <input id="idOfName" v-model="valueOfName" placeholder="Please enter your name." style="width:70%;height:35px;">
               <!-- <p>[Test] the input is: {{ valueOfName }}</p> -->

                <br> <br>
                <p>
                    <strong> Email </strong>
                    <strong style="color:#e37d96;"> * </strong>
                </p>
                <input id="idOfEmail" v-model="valueOfEmail" placeholder="Please enter your email." style="width:70%;height:35px;">
               <!-- <p>[Test] the input is: {{ valueOfEmail }}</p> -->

                <br> <br>
                <p>
                    <strong> Message </strong>
                    <strong style="color:#e37d96;"> * </strong>
                </p>
                <textarea id="idOfMessage" v-model="valueOfMessage" placeholder="Please enter your message." style="width:70%;height:120px;"> </textarea>
               <!-- <p>[Test] the input is: {{ valueOfMessage }}</p> -->

                <!-- submit button - submitMethod() -->
                <br> <br> <br>
                <p>
                    <button class="submitButton" v-on:click="submitMethod">SUBMIT</button>
                </p>
            </div>

        </div>

    </div>
</template>



<script>
    import axios from "axios";

    export default {
        name: "contact.vue",
        data() {
            return {
                isSubmit: false,
                valueOfName: '',
                valueOfEmail: '',
                valueOfMessage: '',
                twitterlogo : require("../assets/twitterlogo.png"),
                Instagramlogo : require("../assets/Instagramlogo.png"),
                facebooklogo :require("../assets/facebooklogo.png")
            }
        },
        methods: {
            submitMethod: function () {
                if (confirm("Do you want to submit?")){
                    let contactData = {
                        "contactName": this.valueOfName,
                        "contactEmail": this.valueOfEmail,
                        "contactMessage": this.valueOfMessage,
                        "contactTime": new Date()
                    }
                   // console.log("[Test] " + contactData.contactName + " " + contactData.contactEmail + " " + contactData.contactMessage + " " + contactData.contactTime + ".")
                    if(contactData.contactName=="" || contactData.contactEmail=="" || contactData.contactMessage==""){
                        alert("Please enter all required fields.")
                    } else{
                        // let reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式
                        let reg = new RegExp("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$")
                        if(!reg.test(contactData.contactEmail)){
                            alert("The email format submitted is incorrect, please check it again!")
                        } else{
                            const _this = this
                            axios.post('/contact/add',
                                {
                                    contactName: contactData.contactName,
                                    contactEmail: contactData.contactEmail,
                                    contactMessage: contactData.contactMessage,
                                    contactTime: contactData.contactTime
                                }
                            ).then(function (contactData) {
                                console.log(contactData)
                                _this.$router.push('/')
                                _this.isSubmit = true
                                alert("Submit successfully!")
                               // location.reload()
                                window.location.href = "Contact"
                            }).catch(error => console.log(error))
                        }
                    }
                }
            } //submitMethod: function ()
        } //methods:
    }

</script>

<style scoped>
    * {
        box-sizing: border-box;
    }

    hr {
        border: 0.5px solid lightgray;
    }

    body {
        margin: 10px;
    }

    /* topping */
    .header {
        background-color: #f1f1f1;
        padding: 20px;
        text-align: center;
    }

    /* navigation bar */
    .topnav {
        overflow: hidden;
        opacity:80%;
        background-color: #cf8878;
        width: 98%;
        position: fixed;
    }

    /* navigation bar - link */
    .topnav a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    /* navigation bar - colour of link */
    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    /* Page layout: three columns */
    .column {
        margin: 20px;
        float: left;
        width: 45%;
       /* width: 30%; */
    }

    /* Page layout: Clear floating after column */
    .row::after {
        content: "";
        display: table;
        clear: both;
    }

    /* the bottom of WebPage */
    .footer {
        padding: 10px;
        text-align: center;
        background: #7db4af;
        margin-top: 100px;
    }

    .submitButton {
        background-color: #7db4af;
        color: #f2f2f2;
        width: 80px;
        height: 30px;
        border: none;
        border-radius: 4px;
        font-size: 15px;
        text-align: center;
        cursor: pointer;
    }

    /* Responsive layout - Change to up-down layout when less than 600 PX */
    @media screen and (max-width: 600px) {
        .column {
            width: 100%;
        }
    }

    /* 响应式布局 - 屏幕尺寸小于 800px 时，两列布局改为上下布局 */
    @media screen and (max-width: 800px) {
        .topnav a {
            width: 100%;
            padding: 10px;
        }
    }

    /* column 3 card part */
    .card {
        background-color: #96aec6;
        padding: 20px;
        margin-top: 20px;
    }

    .error {
        background-color: red;
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
