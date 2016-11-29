package space.eignatik.bugtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import space.eignatik.bugtracker.data.DAO.IssueDAO;
import space.eignatik.bugtracker.model.Issue;

import java.util.List;

@RestController
@RequestMapping()
public class IssueController {

    @Autowired
    IssueDAO issueDAO;

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Issue showIssue(@PathVariable("id") Long id) throws Exception {
        return issueDAO.getItem(id);
    }

    @RequestMapping(value = "post", consumes = "application/json", method = RequestMethod.POST)
    public Issue createIssue(@RequestBody Issue issue) throws Exception {
        issueDAO.createItem(issue);
        return issueDAO.getItem(issue.getId());
    }

    @RequestMapping(value = "put/{id}", consumes = "application/json", method = RequestMethod.PUT)
    public Issue updateIssue(@PathVariable("id") Long id, @RequestBody Issue issue) throws Exception {
        return issueDAO.updateItem(id, issue);
    }

    @RequestMapping(value = "get/all", method = RequestMethod.GET)
    public List<Issue> getAllIssues() throws Exception {
        return issueDAO.getItems();
    }
}
