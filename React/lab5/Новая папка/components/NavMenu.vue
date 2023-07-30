<template>
    <div id="NavMenu">
        <BlockNav :BlockNav="BlockNav"/>
    </div>
</template>
<script>
import BlockNav from './Blocks/BlockNav.vue';
export default {
    data(){
        return{
            BlockNav:[
            'Home',
            'About',
            'Blog',
            'Contacts',
            'Portfolio'
        ],
        show:false
        }   
    },
    components:{
        BlockNav
    },
    
}
</script>
<style lang="scss">
#NavMenu{
    border: 1px solid black;

}
</style>