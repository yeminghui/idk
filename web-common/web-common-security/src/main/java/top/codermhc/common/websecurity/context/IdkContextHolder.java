package top.codermhc.common.websecurity.context;

/**
 * @author yemh
 */
public class IdkContextHolder {

    private static final ThreadLocal<IdkContext> CONTEXT = new ThreadLocal<>();

    public static IdkContext getContext() {
        return CONTEXT.get();
    }

    public static void setContext(IdkContext ctx) {
        CONTEXT.set(ctx);
    }

    public static void clear() {
        CONTEXT.remove();
    }

    private IdkContextHolder() {}
}
