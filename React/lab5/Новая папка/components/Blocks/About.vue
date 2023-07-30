<template>
    <div id="butt">
      <button>{{ About.Text }}</button>
    </div>
</template>
<script>
export default {
    props:['About'],

}
</script>
<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#butt{
      display: flex;
      float: right;
      margin-top: 5px;
        button{
        width:338px ;
        height: 39px;
        text-align: center;
        font-size: 20px;
        color: #181A3F;
        font-weight: 600;
        text-transform: uppercase;
        border: 3px solid #181A3F; 
        font-family: 'Urbanist';
        //margin: 25px 5px 0px 0px;
        }
    }
</style>