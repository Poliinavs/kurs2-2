
<template>
    <div id="cont">
      <div id="containerS">
        <SimpleTitle :SimpleTitle = "SimpleTitle"/>
      </div>
    </div>
      </template>
  
  <script>
  import SimpleTitle from './Blocks/SimpleTitle.vue';
  export default{
     
    components: {
      SimpleTitle
      },
    data(){
      return{
    //     BlockWe:{Articles:"A simple, yet effective three step process."},
    //   BlockT:{Text:"A scelerisque purus semper eget duis at tellus integer malesuada nunc vel risus commodo viverra maecenas doloro accumsan pharetra massa massa ultricie."}
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
      #containerS{
          border: 1px solid #181A3F;
          height: 116px;
          width: 1220px;
          margin: 0px 24px 0px 24px;
          font-family: 'Urbanist';
          gap: 400px;
      }
    }
         
  </style> 
  
  