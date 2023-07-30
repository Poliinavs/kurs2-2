
<template>
  <div id="cont">
    <div id="containerWe">
      <BlockWeT :BlockWeT = "BlockWeT"/>
    </div>
  </div>
    </template>

<script>
import BlockWeT from './Blocks/BlockWeT.vue';
export default{
   
  components: {
    BlockWeT
    },
  data(){
    return{
      // BlockWe:{Articles:"We’re more than just a branding agency."},
      // BlockButt:{Browse:"Browse All services"}
    }
           
    }
  }

</script>

<style lang="scss" scoped>
    @import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
    #cont{
      margin: 0px 110px 0px 110px;
      border: 1px solid #181A3F;
      width: 1268px;
      //height: 835px;
      background-color: white;
    #containerWe{
        border: 1px solid #181A3F;
        height: 116px;
        width: 1220px;
        margin: 0px 24px 0px 24px;
        font-family: 'Urbanist';
    }
  }
       
</style> 

