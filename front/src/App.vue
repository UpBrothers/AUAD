<template>
  <v-app id="inspire">
    <v-app-bar app color="white" flat hide-on-scroll>
      <v-avatar
        :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'"
        size="32"
      ></v-avatar>

      <v-tabs centered class="ml-n9" color="grey darken-1">
        <v-tab v-for="(link, i) in links" :to="link.path" :key="i">
          {{ link.title }}
        </v-tab>
      </v-tabs>

      <v-avatar
        class="hidden-sm-and-down"
        color="grey darken-1 shrink"
        size="32"
      ></v-avatar>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <router-view />

      <v-speed-dial
        v-model="fab"
        bottom
        right
        transition="slide-y-reverse-transition"
        fixed
      >
        <template v-slot:activator>
          <v-btn v-model="fab" color="blue darken-2" dark fab>
            <v-icon v-if="fab"> mdi-close </v-icon>
            <v-icon v-else> mdi-plus </v-icon>
          </v-btn>
        </template>

        <v-btn fab dark small color="green" @click="dialog[0] = true">
          <v-icon>mdi-pencil</v-icon>
        </v-btn>

        <v-btn fab dark small color="indigo" @click="dialog[1] = true">
          <v-icon>mdi-file-document-edit</v-icon>
        </v-btn>
      </v-speed-dial>

      <NewPostDialog :dialog="dialog[0]" @close="dialog[0] = false" />

      <NewSurveyDialog />
    </v-main>
  </v-app>
</template>

<script>
import NewPostDialog from "@/components/NewPostDialog";
import NewSurveyDialog from "@/components/NewSurveyDialog";

export default {
  name: "App",

  components: {
    NewPostDialog,
    NewSurveyDialog,
  },

  data: () => ({
    links: [
      { title: "Dashboard", path: "/Dashboard" },
      { title: "Messages", path: "/Messages" },
      { title: "Profile", path: "/Profile" },
      { title: "Updates", path: "/Updates" },
    ],
    fab: false,
    dialog: [false, false],
  }),
};
</script>
