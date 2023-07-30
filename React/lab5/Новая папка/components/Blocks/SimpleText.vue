<template>
    <div id="rightT">
        <p>{{ SimpleText.Text}}</p>
      </div>

</template>
<script>
export default {
    props:['SimpleText']

}
</script>
<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#rightT{
      display: flex;
      float: right;
      //width: 550px;
      
        p{
        border: 1px solid #181A3F;
        font-size: 17px;
        color: #181A3F;
        //text-transform: uppercase;
        margin-top: 18px;

        font-weight: 400;
        font-family: 'Urbanist';
        width: 420px;
        height: 97px;

    }
    }
</style>