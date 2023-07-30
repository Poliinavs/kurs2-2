<template>
    <div id="NavMenu">
        <BlockNav :BlockNav="BlockNav"/>
    </div>
</template>
<script>
import BlockNav from './Blocks/BlockNav.vue';
export default {
    components:{
        BlockNav
    },
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
        
        
    }
}
</script>
<style lang="scss">
#NavMenu{
    border: 1px solid black;
    
}
</style>