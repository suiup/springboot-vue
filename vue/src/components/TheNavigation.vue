<template>
    <div class="header">
        <a class="logo" href="/">My Harvest</a>
        <router-link to="/">Home</router-link>
        <router-link to ="/About">About</router-link>
        <router-link to ="/Guidelines">Guidelines</router-link>
        <router-link to ="/newCrop">Submit Your Harvest</router-link>
        <router-link to ="/FAQs">FAQs</router-link>
      <!--  <router-link to ="/NotFound">News</router-link> -->
        <router-link to ="/Contact">Contact</router-link>
        <router-link to ="/DataTable">DataTable</router-link>
        <div v-if="verifyLogin()">
            <a href="#" v-on:click="logout" style="float: right">Logout</a>
            <a href="#" style="float: right;">{{username}}</a>
        </div>
        <div v-else>
            <router-link to ="/Register" style="float:right">Register</router-link>
            <router-link to ="/Login" style="float:right">Login</router-link>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TheNavigation",
        data(){
            return {
                username: localStorage.getItem("username")
            }
        },
        methods: {
            logout(){
                localStorage.clear();
                this.$router.push('/');
                location.reload()
            },
            verifyLogin(){
                const check = localStorage.getItem("token");
                console.log("This is localStorage");
                console.log(localStorage);
                console.log(check);
                return check;
            }
        }
    }
</script>

<style scoped>

  .logo {
    font-size: 20px;
    font-weight: bold;
  }

  /* navigation bar */
  .header {
      background-color: #cf8878;
      overflow: hidden;
   /*   opacity:90%;
      width: 100%;
      position: -ms-device-fixed;*/
  }

  /* navigation bar - link */
  .header a {
      float: left;
      display: block;
      color: #f2f2f2;
      text-align: center;
      padding: 15px 15px;
      text-decoration: none;
  }

  /* navigation bar - colour of link */
  .header a:hover {
      background-color: #dddddd;
      color: black;
  }

  /* Responsive layout - Change to up-down layout when less than 800 PX */
  @media screen and (max-width: 800px) {
      .header a {
          width: 100%;
          padding: 10px;
      }
  }

</style>