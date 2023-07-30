<template>
   
    <div id="nav">
        <nav>
            <transition name="fade" mode="out-in">
                <i class="material-icons menu" v-if="!show" @click="show = !show" key="menu">menu</i>
                <i class="material-icons clear" v-else="!show" @click="show = !show" key="clear">clear</i>
            </transition>
            <transition name="fade">
                <ul v-if="show">
                    <li v-for="block in BlockNav">{{ block }}</li>
                </ul>
            </transition>
        </nav>
    </div>
</template>

<script>
export default {
    props:['BlockNav'],
    // data(){
        
    //     //show=false;
        
    // }

}
</script>

<style lang="scss">
 @import url("https://fonts.googleapis.com/icon?family=Material+Icons");
 @import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');


</style>