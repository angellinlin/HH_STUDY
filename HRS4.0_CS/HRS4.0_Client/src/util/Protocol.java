package util;

import model.Resume;

/**
 * 发送数据给服务器，内容包含
 * 1.操作指令：add、delete、update、search
 * 2.操作数据
 */

public class Protocol {

    public String addResumeMessage(Resume resume){
        return String.format("add:%s,%s,%s,%s,%s",resume.getName(),resume.getId(),resume.getSchool(),resume.getStatus(),resume.getDeleteStatus());
    }

    public String deleteResumeMessage(Resume resume){
        return String.format("delete:%s",resume.getId());
    }

    public String updateResumeMessage(Resume oldResume, Resume newResume){
        return String.format("update:%s,%s,%s,%s,%s", oldResume.getId(), newResume.getName(),
                newResume.getId(), newResume.getSchool(),newResume.getStatus());
    }

    public String searchResumeMessage(Resume resume){
        return String.format("search:%s",resume.getId());
    }
}
