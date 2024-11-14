import React, { useState, useEffect } from "react";
import ApiService from "../services/ApiServices";
import Post from "./Post";
import AddPost from "./AddPost";
import PostDetail from "./PostDetail";
import { PostContext } from "../context/PostContext";

function Dashboard() {
    const [posts, setPosts] = useState([]);
    const [error, setError] = useState(null);
    const [refresh, setRefesh] = useState(0);
    const [selectPostIdState, setSelectPostIdState] = useState(1);

    // Fetch posts
    const fetchPosts = async () => {
        try {
            const responseData = await ApiService.getAllPost();
            setPosts(responseData);
        } catch (error) {
            setError("Something went wrong while fetching data");
        }
    }

    useEffect(() => {
        fetchPosts();
    }, [refresh]);

    // Add comment
    const addPost = async (post) => {
        try {
            await ApiService.addPost(post);
            setRefesh(Date.now());
        } catch (error) {
            setError("Something went wrong while add comment");
        }
    }


    // Handle item clicked
    const handleItemClicked = (id) => {
        setSelectPostIdState(id);
    };

    if (error) {
        return <div className="grid-container"><h1>{error}</h1></div>;
    }

    return (
        <React.Fragment>
            <PostContext.Provider value={selectPostIdState}>
                <h1>Dashboard</h1>
                <div className="grid-container">
                    {
                        posts == null ?
                            <p>Loading...</p> :
                            posts.map((post, index) =>
                                <Post key={`${post.id}-${index}`} post={post} onItemClicked={handleItemClicked} />
                            )
                    }
                </div>
                <PostDetail/>
                <AddPost onAddPost={addPost} />
            </PostContext.Provider>
        </React.Fragment>
    );
}

export default Dashboard;