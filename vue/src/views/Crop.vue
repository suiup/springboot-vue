<template>
  <div>
   <!-- <h1>New Crop</h1> -->
      <p style="text-align:center;font-size:40px">New Crop</p>
    <div class="container">
      <form>
        <div class="row">
          <div class="col-25">
            <label for="cropName">*Crop</label>
          </div>
          <div class="col-75">
            <input type="text" id="cropName" v-model="cropName" placeholder="Types of crop">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="cropPrice">*Price</label>
          </div>
          <div class="col-75">
            <input type="number" id="cropPrice" v-model ="cropPrice" placeholder="The price of crop">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="cropWeight">*Weight</label>
          </div>
          <div class="col-75">
            <input type="number" id="cropWeight" v-model="cropWeight" placeholder="The weight of crop">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="cropProduction">*Production</label>
          </div>
          <div class="col-75">
            <input type="text" id="cropProduction" v-model="cropProduction" placeholder="The place of production">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="cropArea">Area</label>
          </div>
          <div class="col-75">
            <input type="text" id="cropArea" v-model="cropArea" placeholder="The area of crop">
          </div>
        </div>
        <div class="row">
          <div class="col-25">
            <label for="cropComment">Comment</label>
          </div>
          <div class="col-75">
            <textarea id="cropComment" v-model="cropComment" placeholder="Write something.." style="height:200px"></textarea>
          </div>
        </div>
        <div class="row">
          <input type="button"  value="Submit" v-on:click="submit">
        </div>
      </form>
    </div>
  </div>
</template>

<script>
 import axios from "axios";

export default {
    name: "Crops.vue",
    data(){
      return {
          cropName: "",
          cropPrice: "",
          cropWeight: "",
          cropProduction: "",
          cropArea: "",
          cropComment: ""
      }
    },
    methods:{
        submit(){
            console.log(this.cropName)
            if(!this.cropName){
                alert("Crop cannot be null");
                return null;
            }
            if(!this.cropPrice){
                alert("Price cannot be null");
                return null;
            }
            if(!this.cropWeight){
                alert("Weight cannot be null");
                return null;
            }
            if(!this.cropProduction){
                alert("Production cannot be null");
                return null;
            }
            const _this = this;
            axios.post("/Crop/add",{
                cropName : this.cropName,
                cropPrice : this.cropPrice,
                cropWeight : this.cropWeight,
                cropProduction: this.cropProduction,
                cropArea : this.cropArea,
                cropComment: this.cropComment,
                userId: localStorage.getItem("userId")
            }).then(function (data) {
                if(data.data.success){
                    alert('Add successful and you could see it in the DataTable');
                    location.reload();
                }else{
                    var flag = confirm(data.data.msg + ", do you want to login now?");
                    if(flag){
                        _this.$router.push('/login');
                    }
                }

            }).catch(error => console.log(error))
        }
    }
}






</script>

<style scoped>
  * {
    box-sizing: border-box;
  }

  input[type=text],[type=number], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    resize: vertical;
  }

  label {
    padding: 12px 12px 12px 0;
    display: inline-block;
  }

  input[type=button] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    float: right;
  }

  input[type=button]:hover {
    background-color: #45a049;
  }

  .container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
  }

  .col-25 {
    float: left;
    width: 30%;
    margin-top: 6px;
  }

  .col-75 {
    float: left;
    width: 60%;
    margin-top: 6px;
  }

  /* Clear floats after the columns */
  .row:after {
    content: "";
    display: table;
    clear: both;
  }

  /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
  @media screen and (max-width: 600px) {
    .col-25, .col-75, input[type=button] {
      width: 100%;
      margin-top: 0;
    }
  }
</style>