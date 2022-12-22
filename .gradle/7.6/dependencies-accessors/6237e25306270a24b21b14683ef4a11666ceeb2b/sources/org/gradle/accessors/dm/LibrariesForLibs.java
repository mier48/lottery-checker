package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects) {
        super(config, providers, objects);
    }

        /**
         * Creates a dependency provider for junit (junit:junit)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() { return create("junit"); }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() { return laccForAndroidxLibraryAccessors; }

    /**
     * Returns the group of libraries at com
     */
    public ComLibraryAccessors getCom() { return laccForComLibraryAccessors; }

    /**
     * Returns the group of libraries at org
     */
    public OrgLibraryAccessors getOrg() { return laccForOrgLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxComposeLibraryAccessors laccForAndroidxComposeLibraryAccessors = new AndroidxComposeLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxDatastoreLibraryAccessors laccForAndroidxDatastoreLibraryAccessors = new AndroidxDatastoreLibraryAccessors(owner);
        private final AndroidxLegacyLibraryAccessors laccForAndroidxLegacyLibraryAccessors = new AndroidxLegacyLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxNavigationLibraryAccessors laccForAndroidxNavigationLibraryAccessors = new AndroidxNavigationLibraryAccessors(owner);
        private final AndroidxPreferenceLibraryAccessors laccForAndroidxPreferenceLibraryAccessors = new AndroidxPreferenceLibraryAccessors(owner);
        private final AndroidxRoomLibraryAccessors laccForAndroidxRoomLibraryAccessors = new AndroidxRoomLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppcompat() { return create("androidx.appcompat"); }

        /**
         * Returns the group of libraries at androidx.activity
         */
        public AndroidxActivityLibraryAccessors getActivity() { return laccForAndroidxActivityLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.compose
         */
        public AndroidxComposeLibraryAccessors getCompose() { return laccForAndroidxComposeLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() { return laccForAndroidxCoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.datastore
         */
        public AndroidxDatastoreLibraryAccessors getDatastore() { return laccForAndroidxDatastoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.legacy
         */
        public AndroidxLegacyLibraryAccessors getLegacy() { return laccForAndroidxLegacyLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() { return laccForAndroidxLifecycleLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.navigation
         */
        public AndroidxNavigationLibraryAccessors getNavigation() { return laccForAndroidxNavigationLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.preference
         */
        public AndroidxPreferenceLibraryAccessors getPreference() { return laccForAndroidxPreferenceLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.room
         */
        public AndroidxRoomLibraryAccessors getRoom() { return laccForAndroidxRoomLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test
         */
        public AndroidxTestLibraryAccessors getTest() { return laccForAndroidxTestLibraryAccessors; }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityActivityLibraryAccessors laccForAndroidxActivityActivityLibraryAccessors = new AndroidxActivityActivityLibraryAccessors(owner);

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.activity.activity
         */
        public AndroidxActivityActivityLibraryAccessors getActivity() { return laccForAndroidxActivityActivityLibraryAccessors; }

    }

    public static class AndroidxActivityActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.activity:activity-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.activity.activity.compose"); }

    }

    public static class AndroidxComposeLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeMaterialLibraryAccessors laccForAndroidxComposeMaterialLibraryAccessors = new AndroidxComposeMaterialLibraryAccessors(owner);
        private final AndroidxComposeRuntimeLibraryAccessors laccForAndroidxComposeRuntimeLibraryAccessors = new AndroidxComposeRuntimeLibraryAccessors(owner);
        private final AndroidxComposeUiLibraryAccessors laccForAndroidxComposeUiLibraryAccessors = new AndroidxComposeUiLibraryAccessors(owner);

        public AndroidxComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for material3 (androidx.compose.material3:material3)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial3() { return create("androidx.compose.material3"); }

        /**
         * Returns the group of libraries at androidx.compose.material
         */
        public AndroidxComposeMaterialLibraryAccessors getMaterial() { return laccForAndroidxComposeMaterialLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.compose.runtime
         */
        public AndroidxComposeRuntimeLibraryAccessors getRuntime() { return laccForAndroidxComposeRuntimeLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.compose.ui
         */
        public AndroidxComposeUiLibraryAccessors getUi() { return laccForAndroidxComposeUiLibraryAccessors; }

    }

    public static class AndroidxComposeMaterialLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxComposeMaterialMaterialLibraryAccessors laccForAndroidxComposeMaterialMaterialLibraryAccessors = new AndroidxComposeMaterialMaterialLibraryAccessors(owner);

        public AndroidxComposeMaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for material (androidx.compose.material:material)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.compose.material"); }

        /**
         * Returns the group of libraries at androidx.compose.material.material
         */
        public AndroidxComposeMaterialMaterialLibraryAccessors getMaterial() { return laccForAndroidxComposeMaterialMaterialLibraryAccessors; }

    }

    public static class AndroidxComposeMaterialMaterialLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeMaterialMaterialIconsLibraryAccessors laccForAndroidxComposeMaterialMaterialIconsLibraryAccessors = new AndroidxComposeMaterialMaterialIconsLibraryAccessors(owner);

        public AndroidxComposeMaterialMaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.compose.material.material.icons
         */
        public AndroidxComposeMaterialMaterialIconsLibraryAccessors getIcons() { return laccForAndroidxComposeMaterialMaterialIconsLibraryAccessors; }

    }

    public static class AndroidxComposeMaterialMaterialIconsLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeMaterialMaterialIconsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for extended (androidx.compose.material:material-icons-extended)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExtended() { return create("androidx.compose.material.material.icons.extended"); }

    }

    public static class AndroidxComposeRuntimeLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeRuntimeRuntimeLibraryAccessors laccForAndroidxComposeRuntimeRuntimeLibraryAccessors = new AndroidxComposeRuntimeRuntimeLibraryAccessors(owner);

        public AndroidxComposeRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.compose.runtime.runtime
         */
        public AndroidxComposeRuntimeRuntimeLibraryAccessors getRuntime() { return laccForAndroidxComposeRuntimeRuntimeLibraryAccessors; }

    }

    public static class AndroidxComposeRuntimeRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeRuntimeRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for livedata (androidx.compose.runtime:runtime-livedata)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLivedata() { return create("androidx.compose.runtime.runtime.livedata"); }

    }

    public static class AndroidxComposeUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxComposeUiUiLibraryAccessors laccForAndroidxComposeUiUiLibraryAccessors = new AndroidxComposeUiUiLibraryAccessors(owner);

        public AndroidxComposeUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.compose.ui"); }

        /**
         * Returns the group of libraries at androidx.compose.ui.ui
         */
        public AndroidxComposeUiUiLibraryAccessors getUi() { return laccForAndroidxComposeUiUiLibraryAccessors; }

    }

    public static class AndroidxComposeUiUiLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeUiUiToolingLibraryAccessors laccForAndroidxComposeUiUiToolingLibraryAccessors = new AndroidxComposeUiUiToolingLibraryAccessors(owner);

        public AndroidxComposeUiUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.compose.ui.ui.tooling
         */
        public AndroidxComposeUiUiToolingLibraryAccessors getTooling() { return laccForAndroidxComposeUiUiToolingLibraryAccessors; }

    }

    public static class AndroidxComposeUiUiToolingLibraryAccessors extends SubDependencyFactory {

        public AndroidxComposeUiUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for preview (androidx.compose.ui:ui-tooling-preview)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPreview() { return create("androidx.compose.ui.ui.tooling.preview"); }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {
        private final AndroidxCoreCoreLibraryAccessors laccForAndroidxCoreCoreLibraryAccessors = new AndroidxCoreCoreLibraryAccessors(owner);

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.core.core
         */
        public AndroidxCoreCoreLibraryAccessors getCore() { return laccForAndroidxCoreCoreLibraryAccessors; }

    }

    public static class AndroidxCoreCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.core.core.ktx"); }

            /**
             * Creates a dependency provider for splashscreen (androidx.core:core-splashscreen)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSplashscreen() { return create("androidx.core.core.splashscreen"); }

    }

    public static class AndroidxDatastoreLibraryAccessors extends SubDependencyFactory {
        private final AndroidxDatastoreDatastoreLibraryAccessors laccForAndroidxDatastoreDatastoreLibraryAccessors = new AndroidxDatastoreDatastoreLibraryAccessors(owner);

        public AndroidxDatastoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.datastore.datastore
         */
        public AndroidxDatastoreDatastoreLibraryAccessors getDatastore() { return laccForAndroidxDatastoreDatastoreLibraryAccessors; }

    }

    public static class AndroidxDatastoreDatastoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxDatastoreDatastoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for preferences (androidx.datastore:datastore-preferences)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPreferences() { return create("androidx.datastore.datastore.preferences"); }

    }

    public static class AndroidxLegacyLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLegacySupportLibraryAccessors laccForAndroidxLegacySupportLibraryAccessors = new AndroidxLegacySupportLibraryAccessors(owner);

        public AndroidxLegacyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.legacy.support
         */
        public AndroidxLegacySupportLibraryAccessors getSupport() { return laccForAndroidxLegacySupportLibraryAccessors; }

    }

    public static class AndroidxLegacySupportLibraryAccessors extends SubDependencyFactory {

        public AndroidxLegacySupportLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for v4 (androidx.legacy:legacy-support-v4)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getV4() { return create("androidx.legacy.support.v4"); }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleLifecycleLibraryAccessors laccForAndroidxLifecycleLifecycleLibraryAccessors = new AndroidxLifecycleLifecycleLibraryAccessors(owner);
        private final AndroidxLifecycleRuntimeLibraryAccessors laccForAndroidxLifecycleRuntimeLibraryAccessors = new AndroidxLifecycleRuntimeLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.lifecycle.lifecycle
         */
        public AndroidxLifecycleLifecycleLibraryAccessors getLifecycle() { return laccForAndroidxLifecycleLifecycleLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.lifecycle.runtime
         */
        public AndroidxLifecycleRuntimeLibraryAccessors getRuntime() { return laccForAndroidxLifecycleRuntimeLibraryAccessors; }

    }

    public static class AndroidxLifecycleLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleLifecycleRuntimeLibraryAccessors laccForAndroidxLifecycleLifecycleRuntimeLibraryAccessors = new AndroidxLifecycleLifecycleRuntimeLibraryAccessors(owner);
        private final AndroidxLifecycleLifecycleViewmodelLibraryAccessors laccForAndroidxLifecycleLifecycleViewmodelLibraryAccessors = new AndroidxLifecycleLifecycleViewmodelLibraryAccessors(owner);

        public AndroidxLifecycleLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.lifecycle.lifecycle.runtime
         */
        public AndroidxLifecycleLifecycleRuntimeLibraryAccessors getRuntime() { return laccForAndroidxLifecycleLifecycleRuntimeLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.lifecycle.lifecycle.viewmodel
         */
        public AndroidxLifecycleLifecycleViewmodelLibraryAccessors getViewmodel() { return laccForAndroidxLifecycleLifecycleViewmodelLibraryAccessors; }

    }

    public static class AndroidxLifecycleLifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleLifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-runtime-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.lifecycle.lifecycle.runtime.ktx"); }

    }

    public static class AndroidxLifecycleLifecycleViewmodelLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleLifecycleViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-viewmodel-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.lifecycle.lifecycle.viewmodel.ktx"); }

    }

    public static class AndroidxLifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-runtime-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.lifecycle.runtime.ktx"); }

    }

    public static class AndroidxNavigationLibraryAccessors extends SubDependencyFactory {
        private final AndroidxNavigationNavigationLibraryAccessors laccForAndroidxNavigationNavigationLibraryAccessors = new AndroidxNavigationNavigationLibraryAccessors(owner);

        public AndroidxNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.navigation.navigation
         */
        public AndroidxNavigationNavigationLibraryAccessors getNavigation() { return laccForAndroidxNavigationNavigationLibraryAccessors; }

    }

    public static class AndroidxNavigationNavigationLibraryAccessors extends SubDependencyFactory {

        public AndroidxNavigationNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (androidx.navigation:navigation-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() { return create("androidx.navigation.navigation.compose"); }

    }

    public static class AndroidxPreferenceLibraryAccessors extends SubDependencyFactory {
        private final AndroidxPreferencePreferenceLibraryAccessors laccForAndroidxPreferencePreferenceLibraryAccessors = new AndroidxPreferencePreferenceLibraryAccessors(owner);

        public AndroidxPreferenceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.preference.preference
         */
        public AndroidxPreferencePreferenceLibraryAccessors getPreference() { return laccForAndroidxPreferencePreferenceLibraryAccessors; }

    }

    public static class AndroidxPreferencePreferenceLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxPreferencePreferenceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for preference (androidx.preference:preference)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("androidx.preference.preference"); }

            /**
             * Creates a dependency provider for ktx (androidx.preference:preference-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.preference.preference.ktx"); }

    }

    public static class AndroidxRoomLibraryAccessors extends SubDependencyFactory {
        private final AndroidxRoomRoomLibraryAccessors laccForAndroidxRoomRoomLibraryAccessors = new AndroidxRoomRoomLibraryAccessors(owner);

        public AndroidxRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.room.room
         */
        public AndroidxRoomRoomLibraryAccessors getRoom() { return laccForAndroidxRoomRoomLibraryAccessors; }

    }

    public static class AndroidxRoomRoomLibraryAccessors extends SubDependencyFactory {

        public AndroidxRoomRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compiler (androidx.room:room-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() { return create("androidx.room.room.compiler"); }

            /**
             * Creates a dependency provider for ktx (androidx.room:room-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.room.room.ktx"); }

            /**
             * Creates a dependency provider for runtime (androidx.room:room-runtime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() { return create("androidx.room.room.runtime"); }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {
        private final AndroidxTestEspressoLibraryAccessors laccForAndroidxTestEspressoLibraryAccessors = new AndroidxTestEspressoLibraryAccessors(owner);
        private final AndroidxTestExtLibraryAccessors laccForAndroidxTestExtLibraryAccessors = new AndroidxTestExtLibraryAccessors(owner);

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.test.espresso
         */
        public AndroidxTestEspressoLibraryAccessors getEspresso() { return laccForAndroidxTestEspressoLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test.ext
         */
        public AndroidxTestExtLibraryAccessors getExt() { return laccForAndroidxTestExtLibraryAccessors; }

    }

    public static class AndroidxTestEspressoLibraryAccessors extends SubDependencyFactory {
        private final AndroidxTestEspressoEspressoLibraryAccessors laccForAndroidxTestEspressoEspressoLibraryAccessors = new AndroidxTestEspressoEspressoLibraryAccessors(owner);

        public AndroidxTestEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at androidx.test.espresso.espresso
         */
        public AndroidxTestEspressoEspressoLibraryAccessors getEspresso() { return laccForAndroidxTestEspressoEspressoLibraryAccessors; }

    }

    public static class AndroidxTestEspressoEspressoLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestEspressoEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.test.espresso.espresso.core"); }

    }

    public static class AndroidxTestExtLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestExtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (androidx.test.ext:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("androidx.test.ext.junit"); }

    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);
        private final ComSquareupLibraryAccessors laccForComSquareupLibraryAccessors = new ComSquareupLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google
         */
        public ComGoogleLibraryAccessors getGoogle() { return laccForComGoogleLibraryAccessors; }

        /**
         * Returns the group of libraries at com.squareup
         */
        public ComSquareupLibraryAccessors getSquareup() { return laccForComSquareupLibraryAccessors; }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAndroidLibraryAccessors laccForComGoogleAndroidLibraryAccessors = new ComGoogleAndroidLibraryAccessors(owner);
        private final ComGoogleCodeLibraryAccessors laccForComGoogleCodeLibraryAccessors = new ComGoogleCodeLibraryAccessors(owner);
        private final ComGoogleDaggerLibraryAccessors laccForComGoogleDaggerLibraryAccessors = new ComGoogleDaggerLibraryAccessors(owner);
        private final ComGoogleFirebaseLibraryAccessors laccForComGoogleFirebaseLibraryAccessors = new ComGoogleFirebaseLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.android
         */
        public ComGoogleAndroidLibraryAccessors getAndroid() { return laccForComGoogleAndroidLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google.code
         */
        public ComGoogleCodeLibraryAccessors getCode() { return laccForComGoogleCodeLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google.dagger
         */
        public ComGoogleDaggerLibraryAccessors getDagger() { return laccForComGoogleDaggerLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google.firebase
         */
        public ComGoogleFirebaseLibraryAccessors getFirebase() { return laccForComGoogleFirebaseLibraryAccessors; }

    }

    public static class ComGoogleAndroidLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAndroidGmsLibraryAccessors laccForComGoogleAndroidGmsLibraryAccessors = new ComGoogleAndroidGmsLibraryAccessors(owner);
        private final ComGoogleAndroidUmpLibraryAccessors laccForComGoogleAndroidUmpLibraryAccessors = new ComGoogleAndroidUmpLibraryAccessors(owner);

        public ComGoogleAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for material (com.google.android.material:material)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial() { return create("com.google.android.material"); }

        /**
         * Returns the group of libraries at com.google.android.gms
         */
        public ComGoogleAndroidGmsLibraryAccessors getGms() { return laccForComGoogleAndroidGmsLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google.android.ump
         */
        public ComGoogleAndroidUmpLibraryAccessors getUmp() { return laccForComGoogleAndroidUmpLibraryAccessors; }

    }

    public static class ComGoogleAndroidGmsLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAndroidGmsPlayLibraryAccessors laccForComGoogleAndroidGmsPlayLibraryAccessors = new ComGoogleAndroidGmsPlayLibraryAccessors(owner);

        public ComGoogleAndroidGmsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.android.gms.play
         */
        public ComGoogleAndroidGmsPlayLibraryAccessors getPlay() { return laccForComGoogleAndroidGmsPlayLibraryAccessors; }

    }

    public static class ComGoogleAndroidGmsPlayLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAndroidGmsPlayServicesLibraryAccessors laccForComGoogleAndroidGmsPlayServicesLibraryAccessors = new ComGoogleAndroidGmsPlayServicesLibraryAccessors(owner);

        public ComGoogleAndroidGmsPlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.android.gms.play.services
         */
        public ComGoogleAndroidGmsPlayServicesLibraryAccessors getServices() { return laccForComGoogleAndroidGmsPlayServicesLibraryAccessors; }

    }

    public static class ComGoogleAndroidGmsPlayServicesLibraryAccessors extends SubDependencyFactory {

        public ComGoogleAndroidGmsPlayServicesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ads (com.google.android.gms:play-services-ads)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAds() { return create("com.google.android.gms.play.services.ads"); }

    }

    public static class ComGoogleAndroidUmpLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAndroidUmpUserLibraryAccessors laccForComGoogleAndroidUmpUserLibraryAccessors = new ComGoogleAndroidUmpUserLibraryAccessors(owner);

        public ComGoogleAndroidUmpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.android.ump.user
         */
        public ComGoogleAndroidUmpUserLibraryAccessors getUser() { return laccForComGoogleAndroidUmpUserLibraryAccessors; }

    }

    public static class ComGoogleAndroidUmpUserLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleAndroidUmpUserMessagingLibraryAccessors laccForComGoogleAndroidUmpUserMessagingLibraryAccessors = new ComGoogleAndroidUmpUserMessagingLibraryAccessors(owner);

        public ComGoogleAndroidUmpUserLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.android.ump.user.messaging
         */
        public ComGoogleAndroidUmpUserMessagingLibraryAccessors getMessaging() { return laccForComGoogleAndroidUmpUserMessagingLibraryAccessors; }

    }

    public static class ComGoogleAndroidUmpUserMessagingLibraryAccessors extends SubDependencyFactory {

        public ComGoogleAndroidUmpUserMessagingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for platform (com.google.android.ump:user-messaging-platform)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlatform() { return create("com.google.android.ump.user.messaging.platform"); }

    }

    public static class ComGoogleCodeLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleCodeFindbugsLibraryAccessors laccForComGoogleCodeFindbugsLibraryAccessors = new ComGoogleCodeFindbugsLibraryAccessors(owner);

        public ComGoogleCodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gson (com.google.code.gson:gson)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGson() { return create("com.google.code.gson"); }

        /**
         * Returns the group of libraries at com.google.code.findbugs
         */
        public ComGoogleCodeFindbugsLibraryAccessors getFindbugs() { return laccForComGoogleCodeFindbugsLibraryAccessors; }

    }

    public static class ComGoogleCodeFindbugsLibraryAccessors extends SubDependencyFactory {

        public ComGoogleCodeFindbugsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jsr305 (com.google.code.findbugs:jsr305)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJsr305() { return create("com.google.code.findbugs.jsr305"); }

    }

    public static class ComGoogleDaggerLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDaggerHiltLibraryAccessors laccForComGoogleDaggerHiltLibraryAccessors = new ComGoogleDaggerHiltLibraryAccessors(owner);

        public ComGoogleDaggerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.dagger.hilt
         */
        public ComGoogleDaggerHiltLibraryAccessors getHilt() { return laccForComGoogleDaggerHiltLibraryAccessors; }

    }

    public static class ComGoogleDaggerHiltLibraryAccessors extends SubDependencyFactory {

        public ComGoogleDaggerHiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (com.google.dagger:hilt-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("com.google.dagger.hilt.android"); }

            /**
             * Creates a dependency provider for compiler (com.google.dagger:hilt-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() { return create("com.google.dagger.hilt.compiler"); }

    }

    public static class ComGoogleFirebaseLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleFirebaseFirebaseLibraryAccessors laccForComGoogleFirebaseFirebaseLibraryAccessors = new ComGoogleFirebaseFirebaseLibraryAccessors(owner);

        public ComGoogleFirebaseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.firebase.firebase
         */
        public ComGoogleFirebaseFirebaseLibraryAccessors getFirebase() { return laccForComGoogleFirebaseFirebaseLibraryAccessors; }

    }

    public static class ComGoogleFirebaseFirebaseLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleFirebaseFirebaseAnalyticsLibraryAccessors laccForComGoogleFirebaseFirebaseAnalyticsLibraryAccessors = new ComGoogleFirebaseFirebaseAnalyticsLibraryAccessors(owner);
        private final ComGoogleFirebaseFirebaseCrashlyticsLibraryAccessors laccForComGoogleFirebaseFirebaseCrashlyticsLibraryAccessors = new ComGoogleFirebaseFirebaseCrashlyticsLibraryAccessors(owner);

        public ComGoogleFirebaseFirebaseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for bom (com.google.firebase:firebase-bom)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBom() { return create("com.google.firebase.firebase.bom"); }

        /**
         * Returns the group of libraries at com.google.firebase.firebase.analytics
         */
        public ComGoogleFirebaseFirebaseAnalyticsLibraryAccessors getAnalytics() { return laccForComGoogleFirebaseFirebaseAnalyticsLibraryAccessors; }

        /**
         * Returns the group of libraries at com.google.firebase.firebase.crashlytics
         */
        public ComGoogleFirebaseFirebaseCrashlyticsLibraryAccessors getCrashlytics() { return laccForComGoogleFirebaseFirebaseCrashlyticsLibraryAccessors; }

    }

    public static class ComGoogleFirebaseFirebaseAnalyticsLibraryAccessors extends SubDependencyFactory {

        public ComGoogleFirebaseFirebaseAnalyticsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (com.google.firebase:firebase-analytics-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("com.google.firebase.firebase.analytics.ktx"); }

    }

    public static class ComGoogleFirebaseFirebaseCrashlyticsLibraryAccessors extends SubDependencyFactory {

        public ComGoogleFirebaseFirebaseCrashlyticsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (com.google.firebase:firebase-crashlytics-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("com.google.firebase.firebase.crashlytics.ktx"); }

    }

    public static class ComSquareupLibraryAccessors extends SubDependencyFactory {
        private final ComSquareupRetrofit2LibraryAccessors laccForComSquareupRetrofit2LibraryAccessors = new ComSquareupRetrofit2LibraryAccessors(owner);

        public ComSquareupLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.squareup.retrofit2
         */
        public ComSquareupRetrofit2LibraryAccessors getRetrofit2() { return laccForComSquareupRetrofit2LibraryAccessors; }

    }

    public static class ComSquareupRetrofit2LibraryAccessors extends SubDependencyFactory {
        private final ComSquareupRetrofit2ConverterLibraryAccessors laccForComSquareupRetrofit2ConverterLibraryAccessors = new ComSquareupRetrofit2ConverterLibraryAccessors(owner);

        public ComSquareupRetrofit2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for retrofit (com.squareup.retrofit2:retrofit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRetrofit() { return create("com.squareup.retrofit2.retrofit"); }

        /**
         * Returns the group of libraries at com.squareup.retrofit2.converter
         */
        public ComSquareupRetrofit2ConverterLibraryAccessors getConverter() { return laccForComSquareupRetrofit2ConverterLibraryAccessors; }

    }

    public static class ComSquareupRetrofit2ConverterLibraryAccessors extends SubDependencyFactory {

        public ComSquareupRetrofit2ConverterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for gson (com.squareup.retrofit2:converter-gson)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getGson() { return create("com.squareup.retrofit2.converter.gson"); }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsLibraryAccessors laccForOrgJetbrainsLibraryAccessors = new OrgJetbrainsLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.jetbrains
         */
        public OrgJetbrainsLibraryAccessors getJetbrains() { return laccForOrgJetbrainsLibraryAccessors; }

    }

    public static class OrgJetbrainsLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinxLibraryAccessors laccForOrgJetbrainsKotlinxLibraryAccessors = new OrgJetbrainsKotlinxLibraryAccessors(owner);

        public OrgJetbrainsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.jetbrains.kotlinx
         */
        public OrgJetbrainsKotlinxLibraryAccessors getKotlinx() { return laccForOrgJetbrainsKotlinxLibraryAccessors; }

    }

    public static class OrgJetbrainsKotlinxLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinxCoroutinesLibraryAccessors laccForOrgJetbrainsKotlinxCoroutinesLibraryAccessors = new OrgJetbrainsKotlinxCoroutinesLibraryAccessors(owner);

        public OrgJetbrainsKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.jetbrains.kotlinx.coroutines
         */
        public OrgJetbrainsKotlinxCoroutinesLibraryAccessors getCoroutines() { return laccForOrgJetbrainsKotlinxCoroutinesLibraryAccessors; }

    }

    public static class OrgJetbrainsKotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public OrgJetbrainsKotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (org.jetbrains.kotlinx:kotlinx-coroutines-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("org.jetbrains.kotlinx.coroutines.android"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.androidx
         */
        public AndroidxVersionAccessors getAndroidx() { return vaccForAndroidxVersionAccessors; }

        /**
         * Returns the group of versions at versions.com
         */
        public ComVersionAccessors getCom() { return vaccForComVersionAccessors; }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        private final AndroidxComposeVersionAccessors vaccForAndroidxComposeVersionAccessors = new AndroidxComposeVersionAccessors(providers, config);
        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.activity (1.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getActivity() { return getVersion("androidx.activity"); }

            /**
             * Returns the version associated to this alias: androidx.appcompat (1.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAppcompat() { return getVersion("androidx.appcompat"); }

            /**
             * Returns the version associated to this alias: androidx.lifecycle (2.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLifecycle() { return getVersion("androidx.lifecycle"); }

            /**
             * Returns the version associated to this alias: androidx.navigation (2.5.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNavigation() { return getVersion("androidx.navigation"); }

            /**
             * Returns the version associated to this alias: androidx.preference (1.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPreference() { return getVersion("androidx.preference"); }

            /**
             * Returns the version associated to this alias: androidx.room (2.4.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRoom() { return getVersion("androidx.room"); }

        /**
         * Returns the group of versions at versions.androidx.compose
         */
        public AndroidxComposeVersionAccessors getCompose() { return vaccForAndroidxComposeVersionAccessors; }

    }

    public static class AndroidxComposeVersionAccessors extends VersionFactory  {

        public AndroidxComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.compose.material (1.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterial() { return getVersion("androidx.compose.material"); }

            /**
             * Returns the version associated to this alias: androidx.compose.material3 (1.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterial3() { return getVersion("androidx.compose.material3"); }

            /**
             * Returns the version associated to this alias: androidx.compose.ui (1.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUi() { return getVersion("androidx.compose.ui"); }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        private final ComSquareupVersionAccessors vaccForComSquareupVersionAccessors = new ComSquareupVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.google
         */
        public ComGoogleVersionAccessors getGoogle() { return vaccForComGoogleVersionAccessors; }

        /**
         * Returns the group of versions at versions.com.squareup
         */
        public ComSquareupVersionAccessors getSquareup() { return vaccForComSquareupVersionAccessors; }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.google.dagger (2.44.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDagger() { return getVersion("com.google.dagger"); }

    }

    public static class ComSquareupVersionAccessors extends VersionFactory  {

        public ComSquareupVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.squareup.retrofit2 (2.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRetrofit2() { return getVersion("com.squareup.retrofit2"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final AndroidBundleAccessors baccForAndroidBundleAccessors = new AndroidBundleAccessors(objects, providers, config);
        private final AndroidxBundleAccessors baccForAndroidxBundleAccessors = new AndroidxBundleAccessors(objects, providers, config);
        private final ComBundleAccessors baccForComBundleAccessors = new ComBundleAccessors(objects, providers, config);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

        /**
         * Returns the group of bundles at bundles.android
         */
        public AndroidBundleAccessors getAndroid() { return baccForAndroidBundleAccessors; }

        /**
         * Returns the group of bundles at bundles.androidx
         */
        public AndroidxBundleAccessors getAndroidx() { return baccForAndroidxBundleAccessors; }

        /**
         * Returns the group of bundles at bundles.com
         */
        public ComBundleAccessors getCom() { return baccForComBundleAccessors; }

    }

    public static class AndroidBundleAccessors extends BundleFactory {

        public AndroidBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

            /**
             * Creates a dependency bundle provider for android.material which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.compose.material:material</li>
             *    <li>androidx.compose.material:material-icons-extended</li>
             *    <li>androidx.compose.material3:material3</li>
             *    <li>com.google.android.material:material</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getMaterial() { return createBundle("android.material"); }

    }

    public static class AndroidxBundleAccessors extends BundleFactory {

        public AndroidxBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

            /**
             * Creates a dependency bundle provider for androidx.lifecycle which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.lifecycle:lifecycle-runtime-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getLifecycle() { return createBundle("androidx.lifecycle"); }

            /**
             * Creates a dependency bundle provider for androidx.preference which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.datastore:datastore-preferences</li>
             *    <li>androidx.preference:preference</li>
             *    <li>androidx.preference:preference-ktx</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getPreference() { return createBundle("androidx.preference"); }

            /**
             * Creates a dependency bundle provider for androidx.room which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.room:room-ktx</li>
             *    <li>androidx.room:room-runtime</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getRoom() { return createBundle("androidx.room"); }

    }

    public static class ComBundleAccessors extends BundleFactory {
        private final ComFirebaseBundleAccessors baccForComFirebaseBundleAccessors = new ComFirebaseBundleAccessors(objects, providers, config);
        private final ComSquareupBundleAccessors baccForComSquareupBundleAccessors = new ComSquareupBundleAccessors(objects, providers, config);

        public ComBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

        /**
         * Returns the group of bundles at bundles.com.firebase
         */
        public ComFirebaseBundleAccessors getFirebase() { return baccForComFirebaseBundleAccessors; }

        /**
         * Returns the group of bundles at bundles.com.squareup
         */
        public ComSquareupBundleAccessors getSquareup() { return baccForComSquareupBundleAccessors; }

    }

    public static class ComFirebaseBundleAccessors extends BundleFactory {

        public ComFirebaseBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

            /**
             * Creates a dependency bundle provider for com.firebase.libs which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.google.firebase:firebase-analytics-ktx</li>
             *    <li>com.google.firebase:firebase-bom</li>
             *    <li>com.google.firebase:firebase-crashlytics-ktx</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getLibs() { return createBundle("com.firebase.libs"); }

    }

    public static class ComSquareupBundleAccessors extends BundleFactory {

        public ComSquareupBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config) { super(objects, providers, config); }

            /**
             * Creates a dependency bundle provider for com.squareup.retrofit2 which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.squareup.retrofit2:converter-gson</li>
             *    <li>com.squareup.retrofit2:retrofit</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getRetrofit2() { return createBundle("com.squareup.retrofit2"); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final ComPluginAccessors paccForComPluginAccessors = new ComPluginAccessors(providers, config);
        private final NlPluginAccessors paccForNlPluginAccessors = new NlPluginAccessors(providers, config);
        private final OrgPluginAccessors paccForOrgPluginAccessors = new OrgPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com
         */
        public ComPluginAccessors getCom() { return paccForComPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.nl
         */
        public NlPluginAccessors getNl() { return paccForNlPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.org
         */
        public OrgPluginAccessors getOrg() { return paccForOrgPluginAccessors; }

    }

    public static class ComPluginAccessors extends PluginFactory {
        private final ComAndroidPluginAccessors paccForComAndroidPluginAccessors = new ComAndroidPluginAccessors(providers, config);
        private final ComGithubPluginAccessors paccForComGithubPluginAccessors = new ComGithubPluginAccessors(providers, config);
        private final ComGooglePluginAccessors paccForComGooglePluginAccessors = new ComGooglePluginAccessors(providers, config);

        public ComPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.android
         */
        public ComAndroidPluginAccessors getAndroid() { return paccForComAndroidPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.com.github
         */
        public ComGithubPluginAccessors getGithub() { return paccForComGithubPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.com.google
         */
        public ComGooglePluginAccessors getGoogle() { return paccForComGooglePluginAccessors; }

    }

    public static class ComAndroidPluginAccessors extends PluginFactory {

        public ComAndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.android.application to the plugin id 'com.android.application'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("com.android.application"); }

            /**
             * Creates a plugin provider for com.android.library to the plugin id 'com.android.library'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("com.android.library"); }

    }

    public static class ComGithubPluginAccessors extends PluginFactory {
        private final ComGithubBenPluginAccessors paccForComGithubBenPluginAccessors = new ComGithubBenPluginAccessors(providers, config);
        private final ComGithubRzabiniPluginAccessors paccForComGithubRzabiniPluginAccessors = new ComGithubRzabiniPluginAccessors(providers, config);

        public ComGithubPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.github.ben
         */
        public ComGithubBenPluginAccessors getBen() { return paccForComGithubBenPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.com.github.rzabini
         */
        public ComGithubRzabiniPluginAccessors getRzabini() { return paccForComGithubRzabiniPluginAccessors; }

    }

    public static class ComGithubBenPluginAccessors extends PluginFactory {
        private final ComGithubBenManesPluginAccessors paccForComGithubBenManesPluginAccessors = new ComGithubBenManesPluginAccessors(providers, config);

        public ComGithubBenPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.github.ben.manes
         */
        public ComGithubBenManesPluginAccessors getManes() { return paccForComGithubBenManesPluginAccessors; }

    }

    public static class ComGithubBenManesPluginAccessors extends PluginFactory {

        public ComGithubBenManesPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.github.ben.manes.versions to the plugin id 'com.github.ben-manes.versions'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getVersions() { return createPlugin("com.github.ben.manes.versions"); }

    }

    public static class ComGithubRzabiniPluginAccessors extends PluginFactory {
        private final ComGithubRzabiniGradlePluginAccessors paccForComGithubRzabiniGradlePluginAccessors = new ComGithubRzabiniGradlePluginAccessors(providers, config);

        public ComGithubRzabiniPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.github.rzabini.gradle
         */
        public ComGithubRzabiniGradlePluginAccessors getGradle() { return paccForComGithubRzabiniGradlePluginAccessors; }

    }

    public static class ComGithubRzabiniGradlePluginAccessors extends PluginFactory {

        public ComGithubRzabiniGradlePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.github.rzabini.gradle.jython to the plugin id 'com.github.rzabini.gradle-jython'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJython() { return createPlugin("com.github.rzabini.gradle.jython"); }

    }

    public static class ComGooglePluginAccessors extends PluginFactory {
        private final ComGoogleDaggerPluginAccessors paccForComGoogleDaggerPluginAccessors = new ComGoogleDaggerPluginAccessors(providers, config);
        private final ComGoogleFirebasePluginAccessors paccForComGoogleFirebasePluginAccessors = new ComGoogleFirebasePluginAccessors(providers, config);
        private final ComGoogleGmsPluginAccessors paccForComGoogleGmsPluginAccessors = new ComGoogleGmsPluginAccessors(providers, config);

        public ComGooglePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.google.dagger
         */
        public ComGoogleDaggerPluginAccessors getDagger() { return paccForComGoogleDaggerPluginAccessors; }

        /**
         * Returns the group of plugins at plugins.com.google.firebase
         */
        public ComGoogleFirebasePluginAccessors getFirebase() { return paccForComGoogleFirebasePluginAccessors; }

        /**
         * Returns the group of plugins at plugins.com.google.gms
         */
        public ComGoogleGmsPluginAccessors getGms() { return paccForComGoogleGmsPluginAccessors; }

    }

    public static class ComGoogleDaggerPluginAccessors extends PluginFactory {
        private final ComGoogleDaggerHiltPluginAccessors paccForComGoogleDaggerHiltPluginAccessors = new ComGoogleDaggerHiltPluginAccessors(providers, config);

        public ComGoogleDaggerPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.google.dagger.hilt
         */
        public ComGoogleDaggerHiltPluginAccessors getHilt() { return paccForComGoogleDaggerHiltPluginAccessors; }

    }

    public static class ComGoogleDaggerHiltPluginAccessors extends PluginFactory {

        public ComGoogleDaggerHiltPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.google.dagger.hilt.android to the plugin id 'com.google.dagger.hilt.android'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("com.google.dagger.hilt.android"); }

    }

    public static class ComGoogleFirebasePluginAccessors extends PluginFactory {

        public ComGoogleFirebasePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.google.firebase.crashlytics to the plugin id 'com.google.firebase.crashlytics'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getCrashlytics() { return createPlugin("com.google.firebase.crashlytics"); }

    }

    public static class ComGoogleGmsPluginAccessors extends PluginFactory {
        private final ComGoogleGmsGooglePluginAccessors paccForComGoogleGmsGooglePluginAccessors = new ComGoogleGmsGooglePluginAccessors(providers, config);

        public ComGoogleGmsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.google.gms.google
         */
        public ComGoogleGmsGooglePluginAccessors getGoogle() { return paccForComGoogleGmsGooglePluginAccessors; }

    }

    public static class ComGoogleGmsGooglePluginAccessors extends PluginFactory {

        public ComGoogleGmsGooglePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.google.gms.google.services to the plugin id 'com.google.gms.google-services'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getServices() { return createPlugin("com.google.gms.google.services"); }

    }

    public static class NlPluginAccessors extends PluginFactory {
        private final NlLittlerobotsPluginAccessors paccForNlLittlerobotsPluginAccessors = new NlLittlerobotsPluginAccessors(providers, config);

        public NlPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots
         */
        public NlLittlerobotsPluginAccessors getLittlerobots() { return paccForNlLittlerobotsPluginAccessors; }

    }

    public static class NlLittlerobotsPluginAccessors extends PluginFactory {
        private final NlLittlerobotsVersionPluginAccessors paccForNlLittlerobotsVersionPluginAccessors = new NlLittlerobotsVersionPluginAccessors(providers, config);

        public NlLittlerobotsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots.version
         */
        public NlLittlerobotsVersionPluginAccessors getVersion() { return paccForNlLittlerobotsVersionPluginAccessors; }

    }

    public static class NlLittlerobotsVersionPluginAccessors extends PluginFactory {
        private final NlLittlerobotsVersionCatalogPluginAccessors paccForNlLittlerobotsVersionCatalogPluginAccessors = new NlLittlerobotsVersionCatalogPluginAccessors(providers, config);

        public NlLittlerobotsVersionPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots.version.catalog
         */
        public NlLittlerobotsVersionCatalogPluginAccessors getCatalog() { return paccForNlLittlerobotsVersionCatalogPluginAccessors; }

    }

    public static class NlLittlerobotsVersionCatalogPluginAccessors extends PluginFactory {

        public NlLittlerobotsVersionCatalogPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for nl.littlerobots.version.catalog.update to the plugin id 'nl.littlerobots.version-catalog-update'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getUpdate() { return createPlugin("nl.littlerobots.version.catalog.update"); }

    }

    public static class OrgPluginAccessors extends PluginFactory {
        private final OrgJetbrainsPluginAccessors paccForOrgJetbrainsPluginAccessors = new OrgJetbrainsPluginAccessors(providers, config);

        public OrgPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.jetbrains
         */
        public OrgJetbrainsPluginAccessors getJetbrains() { return paccForOrgJetbrainsPluginAccessors; }

    }

    public static class OrgJetbrainsPluginAccessors extends PluginFactory {
        private final OrgJetbrainsKotlinPluginAccessors paccForOrgJetbrainsKotlinPluginAccessors = new OrgJetbrainsKotlinPluginAccessors(providers, config);

        public OrgJetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.jetbrains.kotlin
         */
        public OrgJetbrainsKotlinPluginAccessors getKotlin() { return paccForOrgJetbrainsKotlinPluginAccessors; }

    }

    public static class OrgJetbrainsKotlinPluginAccessors extends PluginFactory {

        public OrgJetbrainsKotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.jetbrains.kotlin.android to the plugin id 'org.jetbrains.kotlin.android'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("org.jetbrains.kotlin.android"); }

    }

}
