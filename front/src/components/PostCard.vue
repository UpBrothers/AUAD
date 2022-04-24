<template>
  <v-card :elevation="elevation">
    <v-img
      src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
      height="400px"
      contain
      class="grey darken-4"
    ></v-img>

    <v-card-title> Top western road trips </v-card-title>

    <v-card-text>
      I'm a thing. But, like most politicians, he promised more than he could
      deliver. You won't have time for sleeping, soldier, not with all the bed
      making you'll be doing. Then we'll go with that data file! Hey, you add a
      one and two zeros to that or we walk! You're going to do his laundry? I've
      got to find a way to escape.
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  props: {
    elevation: [Number, String],
  },
};
</script>
