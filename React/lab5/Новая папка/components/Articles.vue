<template>
    <div id="container">
      <div id="contArt">
        <BlockArtTitle :BlockArtTitle = "BlockArtTitle"/>
        <!-- <BlockArtTitle :BlockArtTitle = "BlockArtTitle"/> -->
      </div>
        
    <div id = ContImg>
        <BlockArt :BlockArt = "BlockArt"/>
    </div>
    </div>


</template>

<script>
import BlockArtTitle from './Blocks/BlockArtTitle.vue';
import BlockArt from './Blocks/BlockArt.vue';
export default{
  data(){
    return{
      // BlockArtTitle:{
      //   Articles:"Articles & resources", Browse:"Browse more posts"
      // },
      // BlockWe:{
      //   Articles:"Articles & resources", Browse:"Browse more posts"
      // },
      BlockArt: [
                {src:"ImgCont\\IMAGE.png",  Title:"Marketing / NOV 22, 2021",Inform:"The difference between UX & UI Design: A simple guide for beginner’s", pInform:"Lorem ipsum dolor sit amet, consectetur adipiscing elit lobortis arcu enim urna" },
                {src:"ImgCont\\IMAGE1.png",  Title:"Development / NOV 22, 2021",Inform:"Font sizes in graphic design: The complete guide to follow", pInform:"Lorem ipsum dolor sit amet, consectetur adipiscing elit lobortis arcu enim urna"},
                {src:"ImgCont\\IMAGE2.png",  Title:"Development / NOV 22, 2021",Inform:"8 design systems you can check out and download for free", pInform:"Lorem ipsum dolor sit amet, consectetur adipiscing elit lobortis arcu enim urna"},
                ]
    }
  },
  components:{
    BlockArtTitle,
    BlockArt,
    // BlockWe
    
  }
}
</script>
<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#container{
        height: 818px;
        width: 1268px;
        border: 1px solid black;
        margin: 0px 110px 0px 110px;
        
        background-color: white;
        #contArt{
          // border: 1px solid black;
          // width: 1220px;
          // height: 90px;
          // margin: 0px 24px 0px 24px;
          border: 1px solid #181A3F;
        height: 116px;
        width: 1220px;
        margin: 0px 24px 0px 24px;
        font-family: 'Urbanist';

        }
        // #contArt{
        // border: 1px solid #181A3F;
        // width: 1220px;
        // margin: 0px 24px 0px 24px;
        // height: 90px;
        // // display: flex;
        // // flex-direction: row;
        // }
        #ContImg{
        border: 1px solid #181A3F;
        width: 1220px;
        height: 648px;
        margin: 0px 24px 0px 24px;
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
        flex-direction: column;
        gap: 26px;
        //margin-top: 78px;
      }
      }
        </style>

