<template>
    <div>
       <!-- <h1>DataTable Management</h1> -->
        <p style="text-align:center;font-size:40px">DataTable Management</p>
        <form>
            <table class="dataTable" style="width:70%" align="center" border="1" cellpadding="10" cellspacing="2" bgcolor="#f5f5f5">
                <thead>
                    <tr style="font-weight: bold">
                        <td>DataTable Name</td>
                        <td>Description</td>
                        <td>Operation</td>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Auth</td>
                        <td>This data table defines the user's operation authority, involving addition, deletion, modification, query, and read only. <b>(not recommended to modify)</b> </td>
                        <td> <router-link :to="{name: 'datatable_auth'}"> <input type="button" value="view"> </router-link> </td>
                       <!--
                        <td> <router-link :to="{name: 'contact'}"> <button>test</button> </router-link> </td>
                        -->
                    </tr>
                    <tr>
                        <td>Role</td>
                        <td>This data table defines the roles of users, such as managers, ordinary users, etc. <b>(not recommended to modify)</b> </td>
                        <td> <router-link :to="{name: 'datatable_role'}"> <input type="button" value="view"> </router-link> </td>
                    </tr>
                    <tr>
                        <td>User</td>
                        <td>This data table stores both usernames and passwords of all user groups of the website.</td>
                        <td> <router-link :to="{name: 'datatable_user'}"> <input type="button" value="view"> </router-link> </td>
                    </tr>
                    <tr>
                        <td>Crop</td>
                        <td>This data table stores all the relevant information of the crops, which can be added from <b>Submit Your Harvest</b> page.</td>
                        <td> <router-link :to="{name: 'datatable_crop'}"> <input type="button" value="view"> </router-link> </td>
                    </tr>
                    <tr>
                        <td>Contact</td>
                        <td>This data table stores all the message of users and their contact information, which can be added from <b>Contact</b> page.</td>
                        <td> <router-link :to="{name: 'datatable_contact'}"> <input type="button" value="view"> </router-link> </td>
                    </tr>
                    <tr>
                        <td>Log</td>
                        <td>This data table records all the operation information (mainly insert, delete, update) of all five data tables, except for this log table. Note that all logs are automatically generated by database triggers.</td>
                        <td> <router-link :to="{name: 'datatable_log'}"> <input type="button" value="view"> </router-link> </td>
                    </tr>
                </tbody>
            </table>

            <p>
                Note that the database sever is updating slowly, <br>
                please wait for a while and the data will be displayed soon.
            </p>

            <router-link :to="{name: 'home'}"> <input type="button" value="Home"> </router-link> &nbsp;
            <input type="button" value="Return" onclick="javascript:history.back(-1);"/>
           <!-- <router-link :to="{name: 'datatable'}"> <input type="button" value="Return"> </router-link> -->
        </form>
    </div>
</template>

<script>
</script>

<style>

    input[type=button] {
        background-color: #7db4af;
        color: #f2f2f2;
        border: none;
        border-radius: 4px;
        font-size: 15px;
        text-align: center;
        cursor: pointer;
        padding: 10px 15px;
        margin: 8px 0;
    }

    input[type=button]:hover {
        background-color: #45a049;
    }
</style>
