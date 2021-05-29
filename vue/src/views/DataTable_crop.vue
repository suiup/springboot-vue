<template>
    <div class="mediaTable">
        <!-- <h1>DataTable Management</h1> -->
        <p style="text-align:center;font-size:40px">DataTable Management</p>
        <form>
            <table class="dataTable" style="width:70%" align="center" border="1" cellpadding="10" cellspacing="2" bgcolor="#f5f5f5">
                <thead>
                <tr style="font-weight: bold">
                    <td>Crop ID</td>
                    <td>User ID</td>
                    <td>Crop Name</td>
                    <td>Crop Area</td>
                    <td>Crop Production</td>
                    <td>Crop Weight</td>
                    <td>Crop Price</td>
                    <td>Comment</td>
                    <td>Operation</td>
                </tr>
                </thead>

                <tbody>
                <tr v-for="item in cropData" :key="item.cropId">
                    <td>{{ item.cropId}}</td>
                    <td>{{ item.userId }}</td>
                    <td>{{ item.cropName }}</td>
                    <td>{{ item.cropArea }}</td>
                    <td>{{ item.cropProduction }}</td>
                    <td>{{ item.cropWeight}}</td>
                    <td>{{ item.cropPrice }}</td>
                    <td v-text="item.cropComment"></td>
                    <td>
                        <input type="button" value="Delete" v-on:click="deleteMethod(item.cropId)"/> &nbsp;
                        <input type="button" value="Edit" v-on:click="show(item)"/>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
        <br>

        <modal name="my-crop-modal"
               classes="demo-modal-class"
               :min-width="200"
               :min-height="200"
               :scrollable="true"
               :resizable="true"
               :reset="true"
               width="60%"
               height="auto">
            <form style="border-radius: 5px; background-color: #f2f2f2; padding: 20px;">
                <label for="cropId">ID (no modification allowed):</label>
                <input type="text" id="cropId" v-model="cropId" disabled>

                <label for="cropName">Name: </label>
                <input type="text" id="cropName" v-model="cropName" >

                <label for="cropPrice">Price: </label>
                <input type="text" id="cropPrice" v-model="cropPrice" >

                <label for="cropWeight">Weight: </label>
                <input type="text" id="cropWeight" v-model="cropWeight" >

                <label for="cropProduction">Production: </label>
                <input type="text" id="cropProduction" v-model="cropProduction" >

                <label for="cropArea">Area:</label>
                <input type="text" id="cropArea" v-model="cropArea" >

                <label for="cropComment">Comment:</label>
                <textarea type="text" id="cropComment" v-model="cropComment"></textarea>

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
        name: "datatable_crop.vue",
        data() {
            return {
                userId:"",
                cropId:"",
                cropName:"",
                cropPrice:"",
                cropWeight:"",
                cropProduction:"",
                cropArea:"",
                cropComment:"",
                cropData:[]
            }
        },
        created(){
            this.getCropData()
        },
        methods: {
            show(item){
                this.cropId = item.cropId;
                this.cropName = item.cropName;
                this.cropPrice = item.cropPrice;
                this.cropWeight = item.cropWeight;
                this.cropProduction = item.cropProduction;
                this.cropArea = item.cropArea;
                this.cropComment = item.cropComment;
                this.userId = item.userId;
                this.$modal.show('my-crop-modal');
            },
            hide(){
                this.$modal.hide('my-crop-modal');
            },
            updateMethod(){
                axios.post("/Crop/edit",{
                    cropId: this.cropId,
                    cropName: this.cropName,
                    cropPrice: this.cropPrice,
                    cropWeight: this.cropWeight,
                    cropProduction: this.cropProduction,
                    cropArea: this.cropArea,
                    cropComment: this.cropComment,
                    userId: this.userId
                }).then(function (data) {
                    console.log(data);
                    alert("Edit successfully!");
                    location.reload();
                }).catch(error => console.log(error))
            },
            getCropData() {
                axios.get("/Crop/findAll").then(response => (this.cropData = response.data.data));
            },
            deleteMethod(index) {
                if (confirm("Do you want to delete the selected data?")) {
                    axios.get("/Crop/delete/" + index).then(response => (this.cropData = response.data.data));
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

</style>
