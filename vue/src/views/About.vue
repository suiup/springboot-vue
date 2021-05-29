<template>
    <div id="about">
        <header>
        </header>

        <div id="harvest">
            <div id="harvest-left">
               <h1 style="text-align: center">My Harvest</h1>
                <div id="p1">
                    <p style="font-weight:bold; padding:3% 3%">
                        MYHarvest (Measure Your Harvest) is an opportunity to participate
                        in a unique research project estimating the contribution provided
                        by home grown crops to the overall UK production of food.
                    </p>
                    <p style="padding:3% 3%">
                        As the population of the UK and the world in general continues
                        to increase, growing food at home has never been of more importance.
                        Food security, healthy diets and general well-being can all be
                        enhanced with people using their own spaces to grow and become less
                        reliant on foreign grown products.
                    </p>
                    <p style="padding:3% 3%">
                        However, it is unclear how much food people would be able to produce.
                        MYHarvest can provide important information about the productivity
                        of growing spaces within private spaces in urban areas.
                    </p>
                </div>
            </div>
            <div id="harvest-right" :style="loadImg1">
            </div>
            <!--
            <div id="harvest-right" style="background-image:url('../assets/harvest.png')">
                <img src="../assets/harvest.png" alt=" " width="400">
            </div>
            -->
        </div>

        <div id="opportunity">
            <!--
            <div id="opportunity-left">
                <img src="../assets/opportunity.jpg" alt=" " width="400">
            </div>
            -->
            <div id="opportunity-left" :style="loadImg2">
            </div>
            <div id="opportunity-right">
                <h1 style="text-align: center">THE OPPORTUNITY</h1>
                <div id="p2">
                    <p class = intro style="padding:3% 3%">
                        A University of Sheffield based research team, working
                        alongside members of the public who are using allotments and gardens
                        to grow food. They are gaining insight into the typical yields of
                        certain crops, with people involved across the UK.
                    </p>
                    <p style="padding:3% 3%">
                        By taking part and supplying data from the crops you grow you would be contributing
                        the only accurate estimate of the possible scale of crop growing capacity this century.
                        Not only that but also enabling everyone to understand the importance of urban green spaces
                        in the feeding of not only the UK but the entire world.
                    </p>
                    <p style="padding:3% 3%">
                        It is simple to take part in MYHarvest. For details
                        on how to get involved, click the button for guidelines.
                    </p>
                    <p style="text-align: center;">
                        <a href="/pdf/GUIDELINES.pdf" target="_blank">
                            GUIDELINES
                        </a>
                    </p>
                </div>
            </div>
        </div>

        <div id="challenge">
            <div id="challenge-left">
                <h1 style="text-align: center">THE CHALLENGE</h1>
                <div id="p3">
                    <p style="padding:3% 3%">
                        The ever increasing population of the world, with some projections
                        suggesting 9 billion people by 2050, coupled with the associated
                        increase in urbanised land means that there is an diminishing amount
                        of traditional agricultural land.
                    </p>
                    <p style="padding:3% 3%">
                        More and more people living in urban areas lends itself to a greater
                        reliance on imported food and energy which means more food miles
                        and a larger carbon footprint. Although in some places these foods
                        are travelling within a country, for some countries the climate does
                        not suit mass production of certain crops throughout the year resulting
                        in shipments of foodstuffs via plane and sea.
                    </p>
                    <p style="padding:3% 3%">
                        MYHarvest is looking to explore the
                        possibility of developing a greater reliance on home grown crops
                        within urban spaces, and the potential to expand the use of said spaces.
                        Also, how realistic the use of biofuel production from
                        short rotation coppice within urban area is as a sustainable
                        source of energy going forward.
                    </p>
                </div>
            </div>
            <!--
            <div id="challenge-right">
                <img src="../assets/challenge.jpeg" alt=" " width="400">
            </div>
            -->
            <div id="challenge-right" :style="loadImg3">
            </div>
        </div>

        <footer>
        </footer>

    </div>
</template>

<script>
    export default {
        name: "home",
        data(){
            return {
                imgHarvest : require("../assets/harvest.png"),
                loadImg1: {
                    backgroundImage: 'url(' + require("../assets/harvest.png") + ')',
                    backgroundRepeat: 'no-repeat',
                    backgroundSize: 'cover'
                },
                loadImg2: {
                    backgroundImage: 'url(' + require("../assets/opportunity.jpg") + ')',
                    backgroundRepeat: 'no-repeat',
                    backgroundSize: 'cover'
                },
                loadImg3: {
                    backgroundImage: 'url(' + require("../assets/challenge.jpeg") + ')',
                    backgroundRepeat: 'no-repeat',
                    backgroundSize: 'cover'
                }
            }
        }
    };
</script>

<style scoped>
    a{
        background-color: #127f76;
       /* background-color: #7db4af; */
        border-radius: 5px;
        padding: 5px 5px;
       /* font-size: 2vw; */
        font-size: 25px;
       /* border:15px; */
        border: none;
        cursor: pointer;
        text-align: center;
    }
    img{
        margin-top:27%;
        width:700px;
    }
    a:link, a:visited{
        text-decoration: none;
        color:white;
    }
    .bold{
        font-weight:bold;
    }
    header{
        width: 100%;
        height: 5%;
        position: static;
        background-color: #f0ad4e;
    }
    #about{
        font-family: Garamond, serif;
        font-size: 24px;
    }
    #harvest{
        width: 100%;
        height: 800px;
        position: static;
        overflow: hidden;
    }
    #harvest-left,#harvest-right{
        float: left;
        width: 50%;
        height: 800px;
        position: static;
    }
    #harvest-left{
       /* background-color: #CCFFFF; */
        position: static;
        text-align: left;
        border: 100px;
    }
    #harvest-right{
        background-color: #ccffcc;
        position: static;
    }

    #opportunity{
        width: 100%;
        height: 800px;
        overflow: hidden;
        position: static;
    }
    #opportunity-left,#opportunity-right{
        float: left;
        width: 50%;
        height: 800px;
        position: static;
    }
    #opportunity-left{
        background-color: #ccffcc;
        position: static;
    }
    #opportunity-right{
       /* background-color:#FFFFCC; */
        text-align: left;
        border: 100px;
        position: static;
    }
    #challenge{
        width: 100%;
        height: 800px;
        overflow: hidden;
        position: static;
    }
    #challenge-left,#challenge-right{
        float: left;
        width: 50%;
        height: 800px;
        position: static;
    }
    #challenge-left{
       /* background-color: #FFCC99; */
        text-align: left;
        border: 100px;
        position: static;
    }
    #challenge-right{
        background-color: #ccffcc;
        position: static;
    }
    /*
    footer{
        width: 100%;
        height: 80px;
        background-color: #337ab7;
        position: static;
    }   */
    @media screen and (max-width: 800px) {
        #about {
            width: 100%;
            padding: 10px;
        }
    }
</style>