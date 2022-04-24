<template>
  <v-container>
    <v-row>
      <v-col cols="12" sm="3">
        <v-sheet rounded="lg" min-height="268" class="sticky">
          <!--  -->
        </v-sheet>
      </v-col>

      <v-col cols="12" sm="6">
        <PostCard v-for="n in 4" :class="n > 1 ? 'mt-4' : ''" :key="n" />
      </v-col>

      <v-col cols="12" sm="3">
        <v-sheet rounded="lg" min-height="268" class="sticky">
          <v-calendar ref="calendar" style="height: 300px"></v-calendar>
        </v-sheet>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import PostCard from "../components/PostCard";

export default {
  name: "DashboardView",

  components: {
    PostCard,
  },

  data: () => ({}),
};
</script>

<style scoped>
.sticky {
  position: sticky;
  top: calc(50vh - 134px);
}
</style>
