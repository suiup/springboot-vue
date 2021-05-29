<template>
    <div class="FAQS">
        <p style="text-align:center;font-size:40px">FAQS</p >
        <p class="textTitle"> 1. HOW SHOULD I RECORD INTERCROPPED FRUIT AND VEG?
            <button class="showButton" v-on:click="showQuestion1">+</button>
           <!-- <button class="showButton" v-text="btnText1" v-on:click="showQuestion1"></button> -->
        </p> <hr>
        <!-- <button v-text="btnText" @click="showQuestion1"></button> -->
        <div class="textContent" v-show="isShowQuestion1">
            Intercropping is a great way to make best use of your growing space, but unfortunately it makes measuring your growing areas a little more tricky than if you grew your crops separately! If you grow two or more crop types alternately in the same bed, please record the cultivated area for each crop as the area you think that crop would have taken up if it was grown on its own. Don’t worry if this means that the sum of the individual growing areas you record adds up to more than your actual intercropped area (this can easily happen if you had an efficient intercropping system)! You might also get different area figures for your different intercropped crops, depending on the size and number of plants you have and how densely you could plant them. <br><br>
            Example: you have a 2m x 3m growing bed (i.e. 6 square metres) where you planted runner beans and Brussels sprouts in between the bean poles. You estimate that if you had grown the two crops separately each would need about 2m x 2m, so you record the growing area for each as 4 square metres. <br> <br>
        </div>

        <p class="textTitle"> 2. DO I STILL WEIGH MY CROPS IF THEY ARE DAMAGED/INEDIBLE?
            <button class="showButton" v-on:click="showQuestion2">+</button>
            <!--
            <button class="showButton" v-text="btnText2" v-on:click="showQuestion2"></button>
            -->
        </p> <hr>
        <div class="textContent" v-show="isShowQuestion2">
            If you plant out an area with a crop, we want to hear about what you harvest – even if the crop fails or it’s a poor harvest! If some of your harvest goes mouldy, is eaten by slugs or is damaged/lost in another way, please just weigh the part of the harvest that you can eat. If, for example, half of a courgette is severely damage by slugs, chop that half off and weigh the good half that you can still eat. <br><br>
            It’s really important that the data is representative and realistic, so please be honest and submit data for your crops that fail as well as those that flourish. <br><br>
        </div>

        <p class="textTitle"> 3. HOW CAN I SUBMIT THE AREA FOR A CORDON-TRAINED / ESPALIER FRUIT TREE?
            <button class="showButton" v-on:click="showQuestion3">+</button>
            <!--
            <button class="showButton" v-text="btnText3" v-on:click="showQuestion3"></button>
            -->
        </p> <hr>
        <div class="textContent" v-show="isShowQuestion3">
            There are two crop categories that can be selected for apple or plum trees: <br>
            • Apples / Plums – this is for non-trained fruit trees. Submit the average radius of the tree’s canopy (see Guidelines for details) and the website will calculate the area based on this <br>
            • Trained Apples / Trained Plums – this is for all types of trained fruit trees that don’t have an obvious average radius to measure. The area (m² or ft²) is entered as with other crops – just multiply the width by length of the bed to give the area (see Guidelines for details) <br><br>
            We appreciate that this doesn’t account for the height of the trees or their maturity, though it does give us enough information for our calculations! <br><br>
        </div>

        <p class="textTitle"> 4. I ONLY GROW A FEW PLANTS; CAN I STILL TAKE PART?
            <button class="showButton" v-on:click="showQuestion4">+</button>
            <!--
            <button class="showButton" v-text="btnText4" v-on:click="showQuestion4"></button>
            -->
        </p> <hr>
        <div class="textContent" v-show="isShowQuestion4">
            Yes! Whether you grow in a couple of pots on your patio or in a huge allotment, we´d love to hear from you. If you´re growing one of the 40 different fruits and vegetables we are collecting data on, and you can measure the area it is growing in and the harvest weight, there is nothing to stop you from getting involved. <br><br>
        </div>

        <p class="textTitle"> 5. HOW CAN I FIND OUT THE RESULTS FROM THIS PROJECT?
            <button class="showButton" v-on:click="showQuestion5">+</button>
            <!--
            <button class="showButton" v-text="btnText5" v-on:click="showQuestion5"></button>
            -->
        </p> <hr>
        <div class="textContent" v-show="isShowQuestion5">
            You can find links to the studies we have published so far in the Publications section on our website, and read updates and stories about what we’re up to under News. You can also sign up to our occasional newsletter by emailing <strong><em>myharvest@sheffield.ac.uk</em></strong>, or follow us on <strong><em>Twitter (@MYHarvestUK)</em></strong> or <strong><em>Facebook (/MYHarvestUK)</em></strong> to keep up to date on how the project is developing. <br><br>
        </div>

        <p class="textTitle"> 6. I GROW POTATOES IN TWO SEPARATE BEDS; DO I SUBMIT THEM TOGETHER OR SEPARATELY?
            <button class="showButton" v-on:click="showQuestion6">+</button>
            <!--
            <button class="showButton" v-text="btnText6" v-on:click="showQuestion6"></button>
            -->
        </p> <hr>
        <div class="textContent" v-show="isShowQuestion6">
            This is entirely up to you. You can either: <br>
            • Add the areas of both growing beds together, then submit the harvest weights for both beds <br>
            • Enter the growing areas separately and enter the harvest weights into their corresponding growing area <br><br>
            If you choose to submit the growing areas separately, it is important the weight of the crop harvested is added to the area it was grown in. <br><br>
        </div>

        <p class="textTitle"> 7. I GROW CROPS THAT AREN´T ON YOUR LIST; CAN I SUBMIT THEM ANYWAY?
            <button class="showButton" v-on:click="showQuestion7">+</button>
            <!--
            <button class="showButton" v-text="btnText7" v-on:click="showQuestion7"></button>
            -->
        </p> <hr>
        <div class="textContent" v-show="isShowQuestion7">
            We are focusing on 40 of the most commonly grown crops in the UK (see Guidelines for full list). However, we appreciate that people grow a much more diverse range of fruits and vegetables, so there is an option for you to record data on other crops, which you can add as Other and then put the crop type in the Crop Name or Variety boxes. <br><br>
        </div>

    </div>
</template>



<script>
    export default {
        name: "faqs.vue",
        data() {
            return {
                isShowQuestion1: false,
                isShowQuestion2: false,
                isShowQuestion3: false,
                isShowQuestion4: false,
                isShowQuestion5: false,
                isShowQuestion6: false,
                isShowQuestion7: false,
                /*
                btnText1: "➠",
                btnText2: "➠",
                btnText3: "➠",
                btnText4: "➠",
                btnText5: "➠",
                btnText6: "➠",
                btnText7: "➠"
                */
            }
        },
        created(){
          // this.isShowQuestion1 = false;
        },
        methods: {
            showQuestion1() {
                this.isShowQuestion1 = !this.isShowQuestion1
                /*
                if(this.isShowQuestion1){
                    this.btnText1 = "🔙"
                } else{
                    this.btnText1 = "➠"
                } */
            },
            showQuestion2() {
                this.isShowQuestion2 = !this.isShowQuestion2
                /*
                if(this.isShowQuestion2){
                    this.btnText2 = "🔙"
                } else{
                    this.btnText2 = "➠"
                } */
            },
            showQuestion3() {
                this.isShowQuestion3 = !this.isShowQuestion3
                /*
                if(this.isShowQuestion3){
                    this.btnText3 = "🔙"
                } else{
                    this.btnText3 = "➠"
                } */
            },
            showQuestion4() {
                this.isShowQuestion4 = !this.isShowQuestion4
                /*
                if(this.isShowQuestion4){
                    this.btnText4 = "🔙"
                } else{
                    this.btnText4 = "➠"
                } */
            },
            showQuestion5() {
                this.isShowQuestion5 = !this.isShowQuestion5
                /*
                if(this.isShowQuestion5){
                    this.btnText5 = "🔙"
                } else{
                    this.btnText5 = "➠"
                } */
            },
            showQuestion6() {
                this.isShowQuestion6 = !this.isShowQuestion6
                /*
                if(this.isShowQuestion6){
                    this.btnText6 = "🔙"
                } else{
                    this.btnText6 = "➠"
                }
                */
            },
            showQuestion7() {
                this.isShowQuestion7 = !this.isShowQuestion7
                /*
                if(this.isShowQuestion7){
                    this.btnText7 = "🔙"
                } else{
                    this.btnText7 = "➠"
                }
                 */
            }
        }
    }

</script>

<style scoped>
    .FAQS {
        padding: 10% 10% 10% 10%;
        /*
        padding-left: 10%;
        padding-right: 10%;
        padding-top: 10%;
        padding-bottom: 30%;
        */
        text-align: left;
        color: #cf6666;
       /* background: #EEEEEE; */
        list-style: decimal;
    }

    .showButton {
        float:right;
        font-size:10px;
        background-color:#cf6666;
        color: #f1f1f1;
        /*opacity:50%*/;
        border-radius: 20px;
    }

    .textTitle {
        font-weight: bold;
        font-size:20px;
        color:#cf6666;
    }

    .textContent {
        padding: 2% 2% 2% 2%;
        font-size:18px;
        color: #548681;
        background-color: #f1f1f1;
        border-radius: 8px;
    }

    @media screen and (max-width: 800px) {
        .FAQS {
            width: 100%;
            padding: 10px;
        }
    }

</style>
