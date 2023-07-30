<template>
    <div id = "inform">
            <div id="elem" class="inf"  v-for="inf in BlockLogoI" :key="inf">
                <div id="Title">{{inf.Title}}
                </div>
            </div>
</div>
</template>
<script>
export default {
    props:['BlockLogoI'],
}
</script>
<style lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Urbanist:wght@300&display=swap');
#inform{
    border: 1px solid black;
    width: 230px;
    display: flex;
    height: 285px;
    flex-direction: column;
    gap: 10px;
    #Title{
        font-family: 'Urbanist';
        font-style: normal;
        letter-spacing: 0.8px;
        font-weight: 400;
        font-size: 20px;
        line-height: 22px;
        color: #181A3F;
        display: inline-block;
        margin-bottom: 20px;
        text-transform: uppercase;
        }
}
</style>