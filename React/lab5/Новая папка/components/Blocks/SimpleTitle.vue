<template>
    <div id="title">
      <BlockWe :BlockWe = "BlockWe"/>
    <SimpleText :SimpleText = "SimpleText"/>
    </div>

</template>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#title{
display: flex;
flex-direction: row;
gap: 250px;
}

</style>
<script>
import BlockWe from './BlockWe.vue';
import SimpleText from './SimpleText.vue'
export default {
  props:['SimpleTitle'],
  data(){
  return{
    BlockWe:{Articles:"A simple, yet effective three step process."},
      SimpleText:{Text:"A scelerisque purus semper eget duis at tellus integer malesuada nunc vel risus commodo viverra maecenas doloro accumsan pharetra massa massa ultricie."}
  }
},
    components:{
      BlockWe,
      SimpleText
    }
}
</script>