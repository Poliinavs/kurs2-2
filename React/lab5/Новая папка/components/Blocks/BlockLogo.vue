<template>

    <img src="Logo/IMAGE.png">
    <p>{{BlockLogo.email}}
      </p>
      <p>{{BlockLogo.telephone}}
      </p>

</template>
<script>
export default {
    props:['BlockLogo']

}
</script>
<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
    img{
    margin-top: 100px;
    margin-bottom: 40px;
    width: 236px;
    height:46px;
    }
    p{
    margin: 0px 0px 0px 0px;
    font-weight: 1000;
   
}
:first-letter {
    font-family: "Times New Roman", Times, serif; /* Гарнитура шрифта первой буквы */
    //color: red; /* Красный цвет текста */
    font-family: 'Urbanist';
font-style: normal;
font-weight: 1000;
font-size: 22px;
line-height: 32px;
color: #FF7549;
   }
   ::before {
  content: "/";
}

</style>
