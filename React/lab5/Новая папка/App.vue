<template>
  <NavMenu/>
  <!-- <WeMore/>
  <Simple/>
  <Articles/>
  <Buttons/>
  <Logostr/> -->
</template>

<script>
import NavMenu from './components/NavMenu.vue';
import WeMore from './components/WeMore.vue';
import Articles from './components/Articles.vue';
import Logostr from './components/Logostr.vue';
import Simple from './components/Simple.vue';
import Buttons from './components/Buttons.vue';
export default {
  name: 'App',
  components: {
    NavMenu,
    WeMore,
    Articles,
    Logostr,
    Simple,
    Buttons
    ,
    NavMenu
}
}
</script>

<style lang="scss">
// #app {
//   font-family: 'Urbanist', sans-serif;
//   -webkit-font-smoothing: antialiased;
//   -moz-osx-font-smoothing: grayscale;
//   text-align: center;
//   // color: #2c3e50;
//   // margin-top: 60px;
// }
</style>
