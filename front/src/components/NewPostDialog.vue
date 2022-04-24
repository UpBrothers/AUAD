<template>
  <v-dialog :value="dialog" persistent width="auto">
    <v-card>
      <v-container>
        <v-row>
          <v-col cols="6" class="pa-0 mr-auto">
            <v-card elevation="0">
              <v-card-title>
                <span class="text-h5">새 글 작성</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12">
                      <v-text-field label="제목*" required></v-text-field>
                    </v-col>
                    <v-col cols="12">
                      <v-textarea
                        outlined
                        label="내용*"
                        no-resize
                        rows="8"
                        :value="body"
                      ></v-textarea>
                    </v-col>
                    <v-col cols="12">
                      <v-file-input
                        counter
                        multiple
                        small-chips
                        truncate-length="15"
                      ></v-file-input>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="$emit('close')">
                  Close
                </v-btn>
                <v-btn color="blue darken-1" text @click="$emit('close')">
                  Save
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
          <v-divider vertical></v-divider>
          <v-col cols="6" class="pa-0 ml-auto">
            <PostCard style="height: 100%" elevation="0" />
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
import PostCard from "../components/PostCard";

export default {
  components: {
    PostCard,
  },

  props: {
    dialog: {
      type: Boolean,
      required: true,
    },
  },

  data: () => ({
    title: "",
    body: "",
    images: [],
  }),
};
</script>
