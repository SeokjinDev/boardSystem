import React, { useState } from "react";
import { useNavigate } from "react-router-dom"
import styled from "styled-components"

const Wrapper = styled.div `
    padding: 16px;
    width: 90%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-contents: center;
`;

const Container = styled.div `
    width: 100%;
`;

const Form = styled.form`
    display: flex;
    flex-direction: column;
    width: 100%;
    gap: 16px;
`;

const Input = styled.input`
    padding: 8px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
`;

const TextArea = styled.textarea`
    padding: 8px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    height: 200px;
    resize: none;
`;

const Button = styled.button`
    padding: 12px;
    font-size: 16px;
    color: white;
    background-color: #007bff;
    border: none;
    border-radius: 4px;
    cursor: pointer;

    &:hover {
        background-color: #0056b3;
    }
`;

function PostWritePage(props) {
    const navigate = useNavigate();
    const [ title, setTitle ] = useState("");
    const [ content, setContent ] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log("Title:", title);
        console.log("Content:", content);
        navigate("/");
    };

    return (
        <Wrapper>
            <Container>
                <Form onSubmit={handleSubmit}>
                    <Input
                        type="text"
                        placeholder="글 제목을 입력하세요"
                        value={title}
                        onChange={(event) => setTitle(event.target.value)}
                        required
                    />
                    <TextArea
                        placeholder="글 내용을 입력하세요"
                        value={content}
                        onChange={(event) => setContent(event.target.value)}
                        required
                    />
                    <Button type="submit">글 작성하기</Button>
                </Form>
            </Container>
        </Wrapper>
    )
}

export default PostWritePage;