<template>
    <div id="app">
        <TheNavigation />
        <transition name="fade" mode="out-in">
            <router-view :key="$route.path" />
        </transition>

        <TheFooter />
    </div>
</template>

<script>
import TheNavigation from "@/components/TheNavigation";
import TheFooter from "@/components/TheFooter";

export default {
    components: {
        TheNavigation,
        TheFooter
    }
}
</script>

<style>
    #app {
        font-family: "Avenir", Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }
    @keyframes fadeIn {
        0% {
            opacity: 0;
        }
        50% {
            opacity: 0.5;
        }
        100% {
            opacity: 1;
        }
    }

    @keyframes moveUp {
        0% {
            transform: translateY(0);
        }
        100% {
            transform: translateY(-400px);
        }
    }
</style>
