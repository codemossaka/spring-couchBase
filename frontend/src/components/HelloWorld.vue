<template>
    <v-container>
        <v-layout row>
            <v-flex xs12>
                <v-flex class="md-2">
                    <v-btn @click="collapseAll">collapse Alls</v-btn>
                    <v-btn class="btn btn-primary ml-1" @click="expandAll">expand all</v-btn>
                    <draggable-tree :data="tree1data" m draggable cross-tree>
                        <div slot-scope="{data, store}">
                            <template v-if="!data.isDragPlaceHolder">
                                <v-layout row>
                                    <v-flex class="text-md-left">
                                        <b v-if="data.children && data.children.length"
                                           @click="store.toggleOpen(data)">{{data.open ? '-' : '+'}}&nbsp;</b>
                                        <span><a :href="data.link">{{data.name}}</a></span>
                                    </v-flex>

                                    <v-flex class="text-md-right">
                                        <v-icon color="green" @click="add">playlist_add</v-icon>
                                        <v-icon color="primary" @click="edit(data)">edit</v-icon>
                                        <v-icon color="red" @click="remove(data)">delete</v-icon>
                                        <v-icon @click="show(data)">visibility</v-icon>
                                    </v-flex>
                                </v-layout>

                            </template>
                        </div>
                    </draggable-tree>
                </v-flex>
            </v-flex>
        </v-layout>
        <v-dialog v-model="showModal" persistent max-width="600px">
            <v-card>
                <v-card-title>
                    <span class="headline">User Profile</span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                                <v-text-field
                                        label="Название"
                                        hint="example of persistent helper text"
                                        persistent-hint
                                        required
                                ></v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="Ссылька" required></v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="Кароткая ссылька" required></v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-autocomplete
                                        :items="tree1data"
                                        label="Дочерные ссыльки"
                                        item-text="name"
                                        multiple
                                ></v-autocomplete>
                            </v-flex>
                        </v-layout>
                    </v-container>
                    <small>*indicates required field</small>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" flat @click="showModal = false">Close</v-btn>
                    <v-btn color="blue darken-1" flat @click="showModal = false">Save</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
    </v-container>
</template>

<script>
    import {DraggableTree} from 'vue-draggable-nested-tree'
    import {GET_MENUS} from '@/vuex/types';
    import * as th from 'tree-helper'
    import ModalForm from "./ModalForm";

    export default {
        components: {
            ModalForm,
            DraggableTree
        },
        data: () => ({
            showModal: false,
        }),
        created(){
          this.$store.dispatch(GET_MENUS);
        },
        computed: {
            tree1data() {
                return this.$store.state.menus;
            }
        },
        methods: {
            // add child to tree2
            addChild() {
                this.tree2data[0].children.push({text: 'child'})
            },
            expandAll() {
                th.breadthFirstSearch(this.tree1data, node => {
                    node.open = true
                })
            },
            start(t) {
                console.log(t)
            },
            collapseAll() {
                th.breadthFirstSearch(this.tree1data, node => {
                    node.open = false
                })
            },
            add(){
                this.showModal =true
                console.log("add")
            },
            show(item){
                console.log(item)
            },
            remove(item){
                console.log(item)
            },
            edit(item){
                console.log(item)
            }
        },
    }
</script>

<style lang="scss">
    #app {
        padding: 50px;
    }

    .he-tree {
        border: 1px solid #ccc;
        padding: 20px;
    }

    .tree-node {
    }

    .tree-node-inner {
        padding: 5px;
        border: 1px solid #ccc;
        cursor: pointer;
    }

    .draggable-placeholder {
    }

    .draggable-placeholder-inner {
        border: 1px dashed #0088F8;
        box-sizing: border-box;
        background: rgba(0, 136, 249, 0.09);
        color: #0088f9;
        text-align: center;
        padding: 0;
        display: flex;
        align-items: center;
    }

    .tree3 {
        .tree-node-inner {
            border: none;
            padding: 0px;
        }

        .tree-node-inner-back:hover {
            background: #ddd;
        }
    }

    .tree4 {
        .tree-node-inner {
            border: none;
            border-bottom: 1px solid #ccc;
            padding: 5px 10px;
            backgroud: #ccc;
        }

        .draggable-placeholder-inner {
            background-color: orangered;
        }
    }
</style>
