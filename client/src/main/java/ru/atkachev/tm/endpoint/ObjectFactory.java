
package ru.atkachev.tm.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.atkachev.tm.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateProject_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "createProject");
    private final static QName _CreateProjectResponse_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "createProjectResponse");
    private final static QName _DeleteProject_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "deleteProject");
    private final static QName _DeleteProjectResponse_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "deleteProjectResponse");
    private final static QName _GetProjectList_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "getProjectList");
    private final static QName _GetProjectListResponse_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "getProjectListResponse");
    private final static QName _SetProjectList_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "setProjectList");
    private final static QName _SetProjectListResponse_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "setProjectListResponse");
    private final static QName _UpdateProject_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "updateProject");
    private final static QName _UpdateProjectResponse_QNAME = new QName("http://endpoint.tm.atkachev.ru/", "updateProjectResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.atkachev.tm.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateProject }
     * 
     */
    public CreateProject createCreateProject() {
        return new CreateProject();
    }

    /**
     * Create an instance of {@link CreateProjectResponse }
     * 
     */
    public CreateProjectResponse createCreateProjectResponse() {
        return new CreateProjectResponse();
    }

    /**
     * Create an instance of {@link DeleteProject }
     * 
     */
    public DeleteProject createDeleteProject() {
        return new DeleteProject();
    }

    /**
     * Create an instance of {@link DeleteProjectResponse }
     * 
     */
    public DeleteProjectResponse createDeleteProjectResponse() {
        return new DeleteProjectResponse();
    }

    /**
     * Create an instance of {@link GetProjectList }
     * 
     */
    public GetProjectList createGetProjectList() {
        return new GetProjectList();
    }

    /**
     * Create an instance of {@link GetProjectListResponse }
     * 
     */
    public GetProjectListResponse createGetProjectListResponse() {
        return new GetProjectListResponse();
    }

    /**
     * Create an instance of {@link SetProjectList }
     * 
     */
    public SetProjectList createSetProjectList() {
        return new SetProjectList();
    }

    /**
     * Create an instance of {@link SetProjectListResponse }
     * 
     */
    public SetProjectListResponse createSetProjectListResponse() {
        return new SetProjectListResponse();
    }

    /**
     * Create an instance of {@link UpdateProject }
     * 
     */
    public UpdateProject createUpdateProject() {
        return new UpdateProject();
    }

    /**
     * Create an instance of {@link UpdateProjectResponse }
     * 
     */
    public UpdateProjectResponse createUpdateProjectResponse() {
        return new UpdateProjectResponse();
    }

    /**
     * Create an instance of {@link Project }
     * 
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateProject }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "createProject")
    public JAXBElement<CreateProject> createCreateProject(CreateProject value) {
        return new JAXBElement<CreateProject>(_CreateProject_QNAME, CreateProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProjectResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateProjectResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "createProjectResponse")
    public JAXBElement<CreateProjectResponse> createCreateProjectResponse(CreateProjectResponse value) {
        return new JAXBElement<CreateProjectResponse>(_CreateProjectResponse_QNAME, CreateProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteProject }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "deleteProject")
    public JAXBElement<DeleteProject> createDeleteProject(DeleteProject value) {
        return new JAXBElement<DeleteProject>(_DeleteProject_QNAME, DeleteProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProjectResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteProjectResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "deleteProjectResponse")
    public JAXBElement<DeleteProjectResponse> createDeleteProjectResponse(DeleteProjectResponse value) {
        return new JAXBElement<DeleteProjectResponse>(_DeleteProjectResponse_QNAME, DeleteProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetProjectList }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "getProjectList")
    public JAXBElement<GetProjectList> createGetProjectList(GetProjectList value) {
        return new JAXBElement<GetProjectList>(_GetProjectList_QNAME, GetProjectList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetProjectListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "getProjectListResponse")
    public JAXBElement<GetProjectListResponse> createGetProjectListResponse(GetProjectListResponse value) {
        return new JAXBElement<GetProjectListResponse>(_GetProjectListResponse_QNAME, GetProjectListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetProjectList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetProjectList }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "setProjectList")
    public JAXBElement<SetProjectList> createSetProjectList(SetProjectList value) {
        return new JAXBElement<SetProjectList>(_SetProjectList_QNAME, SetProjectList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetProjectListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetProjectListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "setProjectListResponse")
    public JAXBElement<SetProjectListResponse> createSetProjectListResponse(SetProjectListResponse value) {
        return new JAXBElement<SetProjectListResponse>(_SetProjectListResponse_QNAME, SetProjectListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateProject }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "updateProject")
    public JAXBElement<UpdateProject> createUpdateProject(UpdateProject value) {
        return new JAXBElement<UpdateProject>(_UpdateProject_QNAME, UpdateProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProjectResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateProjectResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.atkachev.ru/", name = "updateProjectResponse")
    public JAXBElement<UpdateProjectResponse> createUpdateProjectResponse(UpdateProjectResponse value) {
        return new JAXBElement<UpdateProjectResponse>(_UpdateProjectResponse_QNAME, UpdateProjectResponse.class, null, value);
    }

}
