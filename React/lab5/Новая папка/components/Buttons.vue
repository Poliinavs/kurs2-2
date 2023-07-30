<template>
    <div id="title">
      <Contact :Contact = "Contact"/>
    <About :About = "About"/>
    </div>

</template>

<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#title{
display: flex;
flex-direction: row;
justify-content: center;
gap: 10px;
width: 1220px;
border: 1px solid black;
margin-left: 130px;

}

</style>
<script>
import About from './Blocks/About.vue';
import Contact from './Blocks/Contact.vue';

export default {
  props:['Buttons'],
  data(){
  return{
    Contact:{Text:"Contact us"},
      About:{Text:"About our agency"}
  }
},
    components:{
      Contact,
      About
    }
}
</script>