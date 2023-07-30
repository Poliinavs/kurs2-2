<template>
      <div id="title">
        <BlockWe :BlockWe = "BlockWe"/>
      <BlockButt :BlockButt = "BlockButt"/>
      </div>

</template>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#title{
  display: flex;
  flex-direction: row;
  gap: 300px;
}
</style>
<script>
import BlockWe from './BlockWe.vue';
import BlockButt from './BlockButt.vue'
export default {
    props:['BlockArtTitle'],
    data(){
    return{
    BlockWe:{Articles:"Articles & resources"},
      BlockButt:{Browse:"Browse more posts"}
    }
  },
      components:{
        BlockWe,
        BlockButt
      }
}
</script>