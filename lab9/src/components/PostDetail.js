import React, { useState, useEffect } from "react";
import ApiService from "../services/ApiServices";
import { useParams } from 'react-router-dom';
import AddComment from "./AddComment";
import { useNavigate } from 'react-router-dom';


function PostDetail() {
    const navigate = useNavigate(); 
    const { id } = useParams();
    const [post, setPost] = useState([]);
    const [error, setError] = useState(null);
    const [refresh, setRefesh] = useState(0);

    // Fetch post by id
    const fetchPost = async () => {
        try {
            const responseData = await ApiService.getPostbyId(id);
            setPost(responseData);
        } catch (error) {
            setError("Something went wrong while fetching data");
        }
    }

    // Delete post by id
    const deletePost = async () => {
        try {
            await ApiService.deletePostbyId(id);
            navigate('/');
        } catch (error) {
            setError("Something went wrong while deleting post");
        }
    }

     // Add comment
     const addComment = async (comment) => {
        try {
            await ApiService.addComment(id, comment);
            setRefesh(Date.now());
        } catch (error) {
            setError("Something went wrong while add comment");
        }
    }


    useEffect(() => {
        console.log("Fetch post by id: ", id);
        fetchPost();
        return () => {
            console.log("Cleanup");
        }
    }, [id, refresh]);

    if (error) {
        return <div ><h1>{error}</h1></div>;
    }

    return (
        <div>
            <div className="post-detail">
                <div className="post-header">
                    <h1 className="post-title">{post.title}</h1>
                    <p className="post-id">Post ID: {post.id}</p>
                    <p className="post-author">By {post.author}</p>
                </div>
                <div className="post-content">
                    <p>{post.content}</p>
                </div>
                <div className="post-comments">
                    <h2>Comments</h2>
                    {post.comments && post.comments.length > 0 ? (
                        post.comments.map((comment, index) => (
                            <div key={index} className="comment">
                                <p className="comment-author">{comment.id} says:</p>
                                <p className="comment-text">{comment.name}</p>
                            </div>
                        ))
                    ) : (
                        <p className="no-comments">No comments yet.</p>
                    )}
                </div>

                <button type="button" onClick={deletePost} className="delete-button" >Delete post</button>
            </div>
            <AddComment  onAddComment={addComment} />
        </div>
    );
}

export default PostDetail;