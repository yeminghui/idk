package top.codermhc.common.websecurity.context;

public class IdkContextHolder {

    private static final ThreadLocal<IdkContext> context = new ThreadLocal<>();

    public static IdkContext getContext() {
        return context.get();
    }

    public static void setContext(IdkContext ctx) {
        context.set(ctx);
    }
}
