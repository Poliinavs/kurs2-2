<template>
    <div id="element" class="inf"  v-for="inf in BlockArt" :key="inf">
        <img v-bind="inf">
        <div id="Title">{{inf.Title}} </div>
        
        <div id="Inform">{{inf.Inform}} </div>
        
        <div id = "pInform">{{ inf.pInform }}</div>
    </div>
</template>
<style lang="scss" scoped>
    @import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
   img{
            display: block;
            width: 388px;
            height: 388px;
        }

        #Title{
        font-family: 'Urbanist';
        font-style: normal;
        font-weight: 500;
        font-size: 18px;
        line-height: 20px;
        color: #181A3F;
        display: inline-block;
        margin-top:23px;
        margin-bottom: 13px;
        text-transform: uppercase;

        }
        #Inform{
        font-family: 'Urbanist';
        font-style: normal;
        font-weight: 600;
        font-size: 28px;
        line-height: 39px;
        text-align: justify;
        display:inline-block;
        color: #555671;
        width: 385px;
        //border-top: 1px solid  #555671;
        //margin: 0px 0px -79px 0px;
       }
       #pInform{
        font-family: 'Urbanist';
        font-style: normal;
        font-weight: 500;
        font-size: 17px;
        line-height: 30px;
        text-align: justify;
        display:inline-block;
        color: #555671;
        width: 318px;
       }

   #element{
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    text-align: start;
    height: 388px;
    //width: 648px;
    //margin-right:115px;
    border:1px solid black;
    gap:10px;
    }

//}
//}
</style>

<script>
export default {
    props:['BlockArt']

}</script>