package proxy;

import java.time.LocalDate;

public class DocumentProxy implements Document {
    private RealDocument realDocument;
    private boolean isProtected;

    public DocumentProxy(RealDocument realDocument, boolean isProtected) {
        this.realDocument = realDocument;
        this.isProtected = isProtected;
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (!isProtected) {
            return realDocument.getContent(user);
        }

        AccessControlService acs = AccessControlService.getInstance();

        if (acs.isAllowed(user.getUsername(), realDocument.getId())) {
            return realDocument.getContent(user);
        }

        throw new AccessDeniedException("Access denied for user: " + user.getUsername());
    }
}

