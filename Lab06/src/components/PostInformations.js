import React, { useState, useEffect } from "react";
import Post from "../model/Post";

export default function PostInformations({ post, onRefresh, handleDelete }) {
    const [formData, setFormData] = useState({
        id: -1,
        title: '',
        author: '',
        content: '',
    });

    useEffect(() => {
        if (post) {
            setFormData({
                id: post.id,
                title: post.title,
                author: post.author,
                content: post.content,
            })
        }
    }, [post]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    const handleClear = (e) => {

        setFormData({
            id: "",
            title: "",
            author: "",
            content: "",

        });
    };

    const isSubmitDisabled =
    !formData.title.trim() || !formData.author.trim() || !formData.content.trim();

    const handleSubmit = (event) => {
        event.preventDefault();
        if (formData.title.trim().length === 0
            || formData.author.trim().length === 0
            || formData.content.trim().length === 0) {
            alert("Please fill in all fields");
        } else {
            Post.updateById(post.id, formData);
            onRefresh();
            handleClear();
        }

    };

    return (
        <div >
            <h1 >Post informations</h1>
            <div className="post-info-container">{
                post == null ?
                    <div ></div>
                    : <form onSubmit={handleSubmit} className="form-container">
                        <input
                            type="text"
                            name="id"
                            value={formData.id}
                            onChange={handleChange}
                            className="text-input"
                            disabled={true}
                        />
                        <input
                            type="text"
                            name="title"
                            value={formData.title}
                            onChange={handleChange}
                            placeholder="Enter post title..."
                            className="text-input"
                        />
                        <input
                            type="text"
                            name="author"
                            value={formData.author}
                            onChange={handleChange}
                            placeholder="Enter author..."
                            className="text-input"
                        />

                        <textarea
                            name="content"
                            value={formData.content}
                            onChange={handleChange}
                            rows="5"
                            cols="33"
                            className="text-input"
                            placeholder="Enter your content here..." />

                        <div className="button-group">
                            <button type="submit" className="edit-button" disabled={isSubmitDisabled}>Update</button>
                            <button type="button" onClick={()=> handleDelete(post)} className="delete-button" disabled={isSubmitDisabled}>Delete</button>
                        </div>
                    </form>}
            </div>
        </div>



    );
}