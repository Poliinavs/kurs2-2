<template>
    <div id="but">
      <button>{{ Contact.Text }}</button>
    </div>
</template>
<script>
export default {
    props:['Contact'],

}
</script>
<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#but{
      display: flex;
      float: right;
      margin-top: 5px;
        button{
        width:255px ;
        height: 41px;
        text-align: center;
        font-size: 20px;
        color: #FFFFFF;
        font-weight: 600;
        text-transform: uppercase;
        border: 0;
        //border: 3px solid #181A3F; 
        font-family: 'Urbanist';
        //margin: 25px 5px 0px 0px;
        background-color: #FF7549;
;
        }
    }
</style>