<template>
    <div id="left">
        <p>{{ BlockWe.Articles }}</p>
      </div>

</template>
<script>
export default {
    props:['BlockWe']

}
</script>
<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#left{
      display: flex;
      float: left;
        p{
        border: 1px solid #181A3F;
        font-size: 40px;
        color: #181A3F;
        text-transform: uppercase;
        margin-top: 16px;
        padding: 0%;
        margin-left: 0%;
        font-weight: 400;
        font-family: 'Urbanist';
        width: 548px;

    }
    }
</style>