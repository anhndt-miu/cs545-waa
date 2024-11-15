import React, { useState, useEffect } from "react";
import ApiService from "../services/ApiServices";
import Post from "./Post";


function Dashboard() {
    const [posts, setPosts] = React.useState([]);
    const [error, setError] = React.useState(null);
    const [fetch] = useState(Date.now());

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
    }, [fetch]);
    

    if (error) {
        return <div className="grid-container"><h1>{error}</h1></div>;
    }

    return (
        <div>
            <h1>Dashboard</h1>
            <div className="grid-container">
                {
                    posts == null ?
                        <p>Loading...</p> :
                        posts.map((post, index) => <div key={`${post.id}-${index}`}>{Post(post = { post })}</div>)
                }
            </div>
            
        </div>
    );
}

export default Dashboard;