<template>
    <div id="right">
      <button>{{ BlockButt.Browse }}</button>
    </div>
</template>
<script>
export default {
    props:['BlockButt'],

}
</script>
<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#right{
      display: flex;
      float: right;
      margin-top: 5px;
        button{
        width:352px ;
        height: 40px;
        text-align: center;
        font-size: 20px;
        color: #181A3F;
        font-weight: 600;
        text-transform: uppercase;
        border: 3px solid #181A3F; 
        font-family: 'Urbanist';
        margin: 25px 5px 0px 0px;
        }
    }
</style>