module.exports = function (grunt) {

  var config = {
    app: 'view',
    dist: 'resources'
  };

  // Project configuration.
  grunt.initConfig({

    yeoman: config,

    //prepare to build a project in .tmp folder
    useminPrepare: {
      html: ['<%= yeoman.app %>/{,*/}*.jsp'],
      options: {
        dest: '<%= yeoman.dist %>'
      }
    },
    //move concatting and uglifying files to dest folder
    'usemin': {
      html: ['<%= yeoman.app %>/{,*/}*.jsp'],
      options: {
        assetsDirs: '<%= yeoman.dist %>'
      }
    },
    //rename file prevent from caching files in browser
    'filerev': {
      dist: {
        src: [
          '<%= yeoman.dist %>/asset/js/{,*/}*.js',
          '<%= yeoman.dist %>/asset/css/{,*/}*.css'
        ]
      }
    },
  });

  // Load the plugin.
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-filerev');
  grunt.loadNpmTasks('grunt-usemin');

  grunt.registerTask('build', [
    'clean:dist',
    'useminPrepare',
    'concat:generated',
    'cssmin:generated',
    'uglify:generated',
    'filerev',
    'usemin'
  ]);
};
