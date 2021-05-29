<template>
    <div>
        <div class="footer">
            <p style="color:#2c3e50">
               <!-- © Copyright 2021 <a href="https://myharvest.org.uk/" style="color:#f1f1f1;text-decoration:none">MYHarvest</a> -->
                © Copyright 2021 <router-link :to="{name: 'home'}" style="color:#f1f1f1;text-decoration:none">MYHarvest</router-link>
                An Ink & Water <a href="http://signature.inkandwater.co.uk/" style="color:#f1f1f1;text-decoration:none">Signature Site</a>
            </p>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TheFooter"
    }
</script>

<style scoped>

  /* the bottom of WebPage */
  .footer {
     /* position: absolute; */
      position: -ms-device-fixed;
      bottom: 0;
      width: 100%;
      padding: 1px;
      margin-top: 100px;
      background: #7db4af;
      text-align: center;
  }

  /* Responsive layout - Change to up-down layout when less than 800 PX */
  @media screen and (max-width: 800px) {
      .footer {
          width: 100%;
         /* padding: 10px; */
      }
  }

</style>