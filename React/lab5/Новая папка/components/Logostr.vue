<template>
<div id="cont">
    <div id="logo">
<BlockLogo :BlockLogo = "BlockLogo"/>
</div>
<div id="cont2">

        <BlockLogoInfo :BlockLogoInfo = "BlockLogoInfo"/>

    <!-- <div id="information">
    <BlockLogoInfo :BlockLogoInfo = "BlockLogoInfoF"/>
    </div> -->
    
</div>

</div>
</template>

<script>
import BlockLogo from './Blocks/BlockLogo.vue';
import BlockLogoInfo from './Blocks/BlockLogoInfo.vue';
export default{
    data(){
        return{
         
            BlockLogo :{
                email:"contact@branding.com",
             telephone:"+1 (414) 840 - 3207"},
             BlockLogoInfo:[{Title:"Pages"},{Title:"Utility Pages"}
             ],
             

        }
    },
    components:{
        BlockLogo,
        BlockLogoInfo
    }
}
</script>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#cont{
    width: 1270px;
    height: 507px;
    border: 1px solid black;
    margin-left: 110px;
    display: flex;
    flex-direction: row;
    gap: 260px;
    #logo{
        
        border:1px solid black;
        width: 281px;
        text-align:left;
        margin-left: 13px;
        color: #181A3F;
        font-family: 'Urbanist';
        font-style: normal;
        font-weight: 400;
        font-size: 22px;
        line-height: 32px;
    }
    #cont2{
        display: flex;
        flex-direction: column;
        width: 720px;
        border:1px solid black;
        // #inff{
        //     margin-top: 100px;
        //     height: 30px;
        //     width: 720px;
        //     border:1px solid black;
        // }
    }


}
</style>