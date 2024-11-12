import React from "react";
import Post from "../model/Post.js";
import PostsComponent from "./Posts.js";

import PostInformations from "./PostInformations.js";
import { useEffect, useState } from "react";

export default function Dashboard() {

    const [posts, setPosts] = useState([]);
    const [refresh, setRefresh] = useState(0)
    const [editPost, setEditPost] = useState(null);

    const fetchPosts = () => {
        setPosts(Post.findAll());
    };

    const refreshPosts = () => {
        setRefresh(Date.now());
    }

    useEffect(() => {
        fetchPosts()
    }, [refresh])

    const onItemClicked = (item) => {
        setEditPost(item);
    };

    const handleDelete = (item) => {
        alert(`Deleting ${item.title}`);
    };

    return (
        <div>
            <PostsComponent posts={posts} onItemClicked={onItemClicked} />
            <PostInformations post={editPost??posts[0]} onRefresh={refreshPosts} handleDelete ={handleDelete} />
        </div>
    );


}