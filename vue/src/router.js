import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";



Vue.use(Router);

export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            name: "home",
            component: Home
        },
        {
            path: "/about",
            name: "about",
            component: () => import(/* webpackChunkName: "about" */ "./views/About.vue")
        },
        {
            path: "/faqs",
            name: "faqs",
            component: () => import(/* webpackChunkName: "about" */ "./views/FAQs.vue")
        },
        {
            path: "/register",
            name: "register",
            component: () => import(/* webpackChunkName: "register" */ "./views/Register")
        },
        {
            path: "/login",
            name: "login",
            component: () => import(/* webpackChunkName: "login" */ "./views/Login")
        },
        {
            path: "/newCrop",
            name: "crop",
            component: () => import(/* webpackChunkName: "crop" */ "./views/Crop")
        },
        {
            path: "/404",
            alias: "*",
            name: "notFound",
            component: ()=>import(/*webpackChunkName: "NotFound" */ "./views/NotFound")

        },
        {
            path:"/guidelines",
            name:"guidelines",
            component: ()=>import(/*webpackChunkName: "NotFound" */ "./views/Guidelines")
        },
        {
            path:"/contact",
            name:"contact",
            component: ()=>import(/*webpackChunkName: "contact" */ "./views/Contact")
        },
        {
            path:"/datatable",
            name:"datatable",
            component: ()=>import(/*webpackChunkName: "datatable" */ "./views/DataTable")
        },
        {
            path:"/datatable_auth",
            name:"datatable_auth",
            component: ()=>import(/*webpackChunkName: "datatable_auth" */ "./views/DataTable_auth")
        },
        {
            path:"/datatable_role",
            name:"datatable_role",
            component: ()=>import(/*webpackChunkName: "datatable_role" */ "./views/DataTable_role")
        },
        {
            path:"/datatable_log",
            name:"datatable_log",
            component: ()=>import(/*webpackChunkName: "datatable_log" */ "./views/DataTable_log")
        },
        {
            path:"/datatable_contact",
            name:"datatable_contact",
            component: ()=>import(/*webpackChunkName: "datatable_contact" */ "./views/DataTable_contact")
        },
        {
            path:"/datatable_user",
            name:"datatable_user",
            component: ()=>import(/*webpackChunkName: "datatable_user" */ "./views/DataTable_user")
        },
        {
            path:"/datatable_crop",
            name:"datatable_crop",
            component: ()=>import(/*webpackChunkName: "datatable_crop" */ "./views/DataTable_crop")
        }
    ]
})