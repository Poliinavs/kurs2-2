<template>
    <div id="info">
        <div id="element" class="inf"  v-for="inf in BlockLogoInfo" :key="inf">
            <div id="Title">{{inf.Title}}
            </div> 
        </div>
   
</div>
<div id="block">
    <BlockLogoI :BlockLogoI="BlockLogoInfoF"/>
     <BlockLogoI :BlockLogoI="BlockLogoInfoS"/>
     <BlockLogoI :BlockLogoI="BlockLogoInfoT"/>
</div>
    
</template>
<script>
import BlockLogoI from './BlockLogoI.vue'
export default {
    props:['BlockLogoInfo'],
    components:{
        BlockLogoI
    },
    data(){
        return{
            BlockLogoInfoF:[{Title:"Home"},{Title:"About"},{Title:"Blog"},{Title:"Blog post"},{Title:"Portfolio"},{Title:"Portfolio single"}
             ],
             BlockLogoInfoS:[{Title:"Packages"},{Title:"Packages single"},{Title:"Contact"},{Title:"Team member"}
             ],
             BlockLogoInfoT:[{Title:"Start Here"},{Title:"Style guide"},{Title:"404 Not Found"},{Title:"Password Protected"},{Title:"Licenses"},{Title:"Changelog"}
             ]
        }
    }
}
</script>
<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#info{
    
        border: 1px solid black;
        width: 720px;
        margin-top: 100px;
        display: flex;
        flex-direction: row;
        gap: 425px;
        #Title{
        font-family: 'Urbanist';
        font-style: normal;
        letter-spacing: 0.8px;
        font-weight: 1000;
        font-size: 20px;
        line-height: 22px;
        color: #181A3F;
        display: inline-block;
        margin-top:23px;
        margin-bottom: 13px;
        text-transform: uppercase;
        }

    }
#block{
    display: flex;
    flex-direction: row;
    gap:13px;
}
</style>